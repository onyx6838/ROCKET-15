package com.vti.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService {

	private IAccountRepository repository;

	public AccountService() throws IOException {
		repository = new AccountRepository();
	}

	@Override
	public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
		return repository.getListAccounts();
	}

	@Override
	public Account getAccountByID(int id) throws Exception {
		return repository.getAccountByID(id);
	}

	@Override
	public void createAccount(String email, String username, String fullName)
			throws ClassNotFoundException, SQLException, Exception {
		repository.createAccount(email, username, fullName);
	}

	@Override
	public void updateAccountByID(int id, String username) throws Exception {
		repository.updateAccountByID(id, username);
	}

	@Override
	public void deleteAccount(int id) throws Exception {
		repository.deleteAccount(id);
	}

	@Override
	public boolean isAccountExists(String username) throws ClassNotFoundException, SQLException, IOException {
		return repository.isAccountExists(username);
	}

	@Override
	public boolean isAccountExists(int id) throws ClassNotFoundException, SQLException, IOException {
		return repository.isAccountExists(id);
	}

}
