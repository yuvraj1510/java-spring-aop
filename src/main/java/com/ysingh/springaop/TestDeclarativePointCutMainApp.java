package com.ysingh.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ysingh.springaop.declarative.dao.BookDAO;

public class TestDeclarativePointCutMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println("------- BOOK DAO STARTS -------");
		com.ysingh.springaop.declarative.dao.BookDAO bookDAO = context.getBean(BookDAO.class);
		
		bookDAO.setId("ID-001");
		bookDAO.setName("Java Fundamentals");
		
		bookDAO.getId();
		bookDAO.getName();
		
		bookDAO.addBook();
		System.out.println("------- BOOK DAO ENDS -------");
		
		context.close();
	}

}
