package model;

import java.util.HashMap;
import java.util.Map;

public class Account {
	String userId;
	String username;
	String password;
	String email;
	String lastname;
	String firstname;
	boolean login;
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
		// TODO: verify account password from database and assign following fields
		this.userId = null;
		this.email = null;
		this.lastname = null;
		this.firstname = null;
		if (this.lastname == null && this.firstname == null) {
			this.login = false;
		} else {
			this.login = true;
		}
	}

	private Account(String username, String password, String email, String lastname, String firstname) {
		this.userId = "000";
		this.username = username;
		this.password = password;
		this.email = email;
		this.lastname = lastname;
		this.firstname = firstname;
        this.login = true;
	}

	public Map<String, String> getInfo() {
		Map<String, String> info = new HashMap<String, String>();
		info.put("userId", this.userId);
		info.put("username", this.username);
		info.put("lastname", this.lastname);
		info.put("firstname", this.firstname);
        return info;
	}
	
	/**
	 * Get login status of the account
	 * 
	 * @return Map<String, String> that stores necessary information of an account
	 * 							   if the account username and password is matched.
	 * 							   If not, return empty map
	 */
	public Map<String, String> isLogin() {
		return this.login ? this.getInfo() : new HashMap<String, String>();
	}
	
	/**
	 * Signup an new account with unique email and username
	 *
	 * @param username String
	 * @param password String
	 * @param email String
	 * @param firstname String
	 * @param lastname String
	 * @return Map<String, String> that stores necessary information of an account
	 */
	public static Map<String, String> signup(String username, String password, String email, String lastname,
											 String firstname) {
		// TODO: check information is unique, save account to database, assign
		Account newAccount = new Account(username, password, email, lastname, firstname);
		return newAccount.getInfo();
	}

}