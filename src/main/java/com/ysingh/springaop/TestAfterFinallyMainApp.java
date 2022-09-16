package com.ysingh.springaop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ysingh.springaop.joinpoint.dao.EquipmentDAO;

public class TestAfterFinallyMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println("\n------- EQUIPMENT DAO STARTS -------");
		com.ysingh.springaop.joinpoint.dao.EquipmentDAO equipmentDAO = context.getBean(EquipmentDAO.class);
		
		List<EquipmentDAO> equipments = equipmentDAO.findEquipments();
		
		System.out.println("\nAfter Modifying the Result - Returning");
		System.out.println(equipments);
		System.out.println("\n------- EQUIPMENT DAO ENDS -------\n");
		
		context.close();
	}

}
