package com.trello.dao;

import com.trello.domain.Account;

public interface AccountDao extends Dao<Account> {
	
	void create(Account account, String password);
	
	Account findByUsername(String username);
}