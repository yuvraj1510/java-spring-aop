package com.ysingh.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ysingh.springaop.joinpoint.dao.EquipmentDAO;

public class TestAfterReturningMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println("\n------- EQUIPMENT DAO STARTS -------");
		com.ysingh.springaop.joinpoint.dao.EquipmentDAO equipmentDAO = context.getBean(EquipmentDAO.class);
		
		equipmentDAO.setId("ID-001");
		try {
			equipmentDAO.deleteEquipment(equipmentDAO);
		} catch (Exception ex) {
			System.out.println("\nMain Program : Exception caught : "+ex);
		}
		
		System.out.println("\nMain Program : TestAfterReturningMainApp");
		
		System.out.println("\n------- EQUIPMENT DAO ENDS -------\n");
		
		context.close();
	}

}
