package com.trello.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.trello.dao.AccountDao;
import com.trello.dao.HbnAccountDao;
import com.trello.domain.Account;


@Service
@Transactional(readOnly = true) //Domyslan definicja transakcji
public class AccountServiceImpl implements AccountService{
	
	@Autowired HbnAccountDao accountDao;
	
	
	//Sprawdzanie powialania nazwy usera
	private void validateUsername(String username, Errors errors){
		if(accountDao.findByUsername(username) != null){
			errors.rejectValue("username", "error.duplicate",
			new String[]{username}, null);
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public boolean registerAccount(Account account, String password, Errors errors) {
		// TODO Auto-generated method stub
		
		//validateUsername(account.getUsername(), errors);
		accountDao.create(account);
		return true;
	}
	
	

}

