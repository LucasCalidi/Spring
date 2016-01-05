package com.trello.domain;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;





@Entity

public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id")
	private Long id;
	
	@Column(name= "username")
	private String username;
	
	@Column(name= "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "marketing_ok")
	private boolean marketingOk = true;
	
	@Column(name= "enabled")
	private boolean enabled = true;
	
	@Column(name= "date_created")
	private Date dateCreated;
	
	@Column(name= "password")
	private String password;
	
	//=======Gettery=========/
	
	
	public String getPassword() {
		return password;
	}

	public long getId(){
		return id;
	}
	
	@NotNull
	public String getUsername() {
		return username;
	}
	
	@NotNull
	public String getFirstName() {
		return firstName;
	}
	
	@NotNull
	public String getLastName() {
		return lastName;
	}
	
	@NotNull
	public String getEmail() {
		return email;
	}
	
	@NotNull
	public boolean isMarketingOk() {
		return marketingOk;
	}
	
	@NotNull
	public boolean isEnabled() {
		return enabled;
	}
	
	@NotNull
	public Date getDateCreated() {
		return dateCreated;
	}
	
	//=======Settery========/
	

	public void setPassword(String password) {
		this.password = password;
	}

	
	@SuppressWarnings("unused")
	public void setId(Long id){
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setMarketingOk(boolean marketingOk) {
		this.marketingOk = marketingOk;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}	
	

}