package com.ysingh.springaop.expression.dao;

import org.springframework.stereotype.Component;

import com.ysingh.springaop.expression.model.Account;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH INPUT ACCOUNT");
	}
	
	public void addAccount(Account account, boolean isVip) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH INPUT ACCOUNT AS VIP ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": DOING MY WORK: WRITING CODE");
		return true;
	}
}
