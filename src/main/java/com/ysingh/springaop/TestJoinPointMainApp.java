package com.ysingh.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ysingh.springaop.joinpoint.dao.EquipmentDAO;

public class TestJoinPointMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println("\n------- EQUIPMENT DAO STARTS -------");
		com.ysingh.springaop.joinpoint.dao.EquipmentDAO equipmentDAO = context.getBean(EquipmentDAO.class);
		
		equipmentDAO.setId("ID-001");
		equipmentDAO.setName("Iphone 14");
		
		equipmentDAO.addEquipment();
		
		equipmentDAO.addEquipmentWithIdAndName(equipmentDAO, true);
		System.out.println("------- EQUIPMENT DAO ENDS -------\n");
		
		context.close();
	}

}
