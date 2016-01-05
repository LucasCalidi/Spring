package com.trello.service;

import com.trello.domain.Account;
import org.springframework.validation.Errors;

public interface AccountService {
	
	boolean registerAccount(
			Account account,
			String password,
			Errors errors);

}