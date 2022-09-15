package com.ysingh.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ysingh.springaop.expression.dao.AccountDAO;
import com.ysingh.springaop.expression.dao.MembershipDAO;
import com.ysingh.springaop.expression.model.Account;

public class ExpressionMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println("------- ACCOUNT DAO STARTS -------");
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		accountDAO.addAccount();
		Account account = new Account();
		accountDAO.addAccount(account);
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		System.out.println("------- ACCOUNT DAO ENDS -------");
		
		System.out.println("\n------- MEMBERSHIP DAO STARTS -------");
		MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
		membershipDAO.addAccount();
		membershipDAO.addUser();
		membershipDAO.addEmployee();
		membershipDAO.goToSleep();
		System.out.println("------- MEMBERSHIP DAO ENDS -------");
		
		context.close();
	}

}
