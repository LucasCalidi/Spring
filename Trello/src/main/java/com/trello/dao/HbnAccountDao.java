package com.trello.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trello.domain.Account;

@Repository
public class HbnAccountDao extends AbstractHbnDao<Account> implements AccountDao{

	@Autowired
	public HbnAccountDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}


	//Zapytanie aktualizujace JDBC
	private static final String UPDATE_PASSWORD_SQL = "update account set password = ? where username = ?";
	
	
	//Szablon JDBC

	
	@Override
	public void create(Account account, String password) {
		// TODO Auto-generated method stub
		create(account);
			
	}

	
	//Wywołanie zapytania
	@Override
	public Account findByUsername(String username) {
		// TODO Auto-generated method stub
		
		Query q = getSession().getNamedQuery("findAccountByUsername");
		q.setParameter("username", username);
		
		return (Account) q.uniqueResult();
	}

	

}

