package com.ysingh.springaop.declarative.dao;

import org.springframework.stereotype.Component;

@Component
public class BookDAO {
	
	private String id;
	private String name;
	
	public String getId() {
		System.out.println(getClass() + ": in getId()");
		return id;
	}
	public void setId(String id) {
		System.out.println(getClass() + ": in setId()");
		this.id = id;
	}
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public void addBook() {
		System.out.println(getClass() + ": ADDING THE BOOK");
	}
}
