package com.trello.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.ScriptAssert;


/*
@ScriptAssert(
		lang = "javascript",
		script = "_this.confirmPassword.equals(_this.password)",
		message = "account.password.mismatch.message")
*/

@ScriptAssert(
		lang = "javascript",
		script = "_this.confirmPassword != null && _this.confirmPassword.equals(_this.password)",
		message = "account.password.mismatch.message")

public class AccountForm {
		
	//Dane osobowe
	private String username;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String email;
	
	//Zgoda na informacje marketingowe
	private boolean marketingOk = true;
	//Potwierdzenie umowy
	private boolean acceptTerms = false;
	
	
	
	//=======Gettery========//
	@NotNull
	@Size(min = 1, max = 50)
	public String getUsername(){
		return username;
	}
	
	
	@NotNull
	@Size(min = 1, max = 50)
	public String getPassword() {
		return password;
	}
	
	@NotNull
	@Size(min = 1, max = 50)
	public String getFirstName() {
		return firstName;
	}
	
	@NotNull
	@Size(min = 1, max = 50)
	public String getLastName() {
		return lastName;
	}
	
	@NotNull
	@Size(min = 1, max = 50)
	@Email
	public String getEmail() {
		return email;
	}
	

	public String getConfirmPassword() {
		return confirmPassword;
	}	
	
	public boolean isMarketingOk() {
		return marketingOk;
	}
	
	
	@AssertTrue(message = "{account.acceptTerms.assertTrue.message}")
	public boolean isAcceptTerms() {
		return acceptTerms;
	}
	//========Settery=======//
	public void setUsername(String username){
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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


	public void setAcceptTerms(boolean acceptTerms) {
		this.acceptTerms = acceptTerms;
	}

	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("username", username)
				.append("firstName", firstName)
				.append("lastName", lastName)
				.append("email", email)
				.append("marketingOk", marketingOk)
				.append("acceptTerms", acceptTerms)
				.toString();
	}

}