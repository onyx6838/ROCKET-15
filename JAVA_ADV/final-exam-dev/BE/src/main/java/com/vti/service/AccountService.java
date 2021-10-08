package com.vti.service;

import com.vti.config.event.OnSendRegistrationUserConfirmViaEmailEvent;
import com.vti.entity.Account;
import com.vti.entity.authentication.RegistrationUserToken;
import com.vti.entity.authentication.ResetPasswordToken;
import com.vti.entity.enumerate.UserStatus;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IRegistrationAccountTokenRepository;
import com.vti.repository.IResetPasswordTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository repository;

    @Autowired
    private IResetPasswordTokenRepository resetPasswordTokenRepository;

    // thong bao cho noi khac (ben thu 3)
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private IRegistrationAccountTokenRepository registrationAccountTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Value("${reset-password.token.expired-time}")
//    private long resetPasswordTokenExpiredTime;

    @Value("${registration.token.expired-time}")
    private long registrationPasswordTokenExpiredTime;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(account.getUsername(), account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getRole()));
    }

    @Override
    public Account getAccountByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Account findById(int id) {
        return repository.findById(id).get();
    }

    /**
     * Registration && Reset password
     */

    @Override
    public void createAccount(Account account) {
        // create user
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        repository.save(account);

        // create new user registration token
        createNewRegistrationUserToken(account);

        // send email to confirm
        sendConfirmAccountRegistrationViaEmail(account.getEmail());
    }

    @Override
    public Account findAccountByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void activeAccount(String token) {
        RegistrationUserToken registrationUserToken = registrationAccountTokenRepository.findByToken(token);

        Account account = registrationUserToken.getAccount();
        account.setStatus(UserStatus.ACTIVE);

        repository.save(account);

        // remove Registration User Token
        registrationAccountTokenRepository.deleteById(registrationUserToken.getId());
    }

    @Override
    public void sendConfirmAccountRegistrationViaEmail(String email) {
        eventPublisher.publishEvent(new OnSendRegistrationUserConfirmViaEmailEvent(email)); // event de xu ly
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        // get token
        ResetPasswordToken resetPasswordToken = getResetPasswordToken(token);

        // change password
        Account user = resetPasswordToken.getAccount();
        user.setPassword(passwordEncoder.encode(newPassword));
        repository.save(user);		// ???

        deleteResetPasswordTokenByAccountId(resetPasswordToken.getId());
    }

    @Override
    public ResetPasswordToken getResetPasswordToken(String token) {
        return resetPasswordTokenRepository.findByToken(token);
    }

    @Override
    public void deleteResetPasswordTokenByAccountId(int accountId) {
        resetPasswordTokenRepository.deleteByUserId(accountId);
    }

    private void createNewRegistrationUserToken(Account account) {
        // create new token for confirm Registration
        final String newToken = UUID.randomUUID().toString();
        RegistrationUserToken token = new RegistrationUserToken(newToken, account, registrationPasswordTokenExpiredTime);

        registrationAccountTokenRepository.save(token);
    }
}
