package com.ysingh.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
	}
	
	public void addUser() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A UER");
	}
	
	public boolean addEmployee() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A EMPLOYEE");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": GOING TO SLEEP\n");
	}
}
