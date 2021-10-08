package com.vti.service;

import com.vti.config.resourceproperties.ServerProperty;
import com.vti.entity.Account;
import com.vti.repository.IRegistrationAccountTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRegistrationAccountTokenRepository registrationAccountTokenRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ServerProperty serverProperty;

    @Override
    public void sendRegistrationUserConfirm(String email) {
        Account account = accountService.findAccountByEmail(email);
        String token = registrationAccountTokenRepository.findByAccountId(account.getId());

        String confirmationUrl = serverProperty.getUrl() +  "/api/v1/accounts/activeUser?token=" + token;

        String subject = "Xác Nhận Đăng Ký Account";
        String content = "Bạn đã đăng ký thành công. Click vào link dưới đây để kích hoạt tài khoản \n"
                + confirmationUrl;

        sendEmail(email, subject, content);
    }

    private void sendEmail(final String recipientEmail, final String subject, final String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(content);

        mailSender.send(message);
    }

    @Override
    public void sendResetPassword(Account account, String token) {

    }
}
