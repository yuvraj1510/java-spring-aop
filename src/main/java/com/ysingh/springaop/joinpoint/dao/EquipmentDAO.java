package com.ysingh.springaop.joinpoint.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EquipmentDAO {
	
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "EquipmentDAO [id=" + id + ", name=" + name + "]";
	}

	public void addEquipment() {
		System.out.println(getClass() + ": ADDING THE EQUIPMENT");
	}
	
	public void addEquipmentWithIdAndName(EquipmentDAO equipmentDAO, boolean isPremium) {
		System.out.println(getClass() + ": ADDING THE EQUIPMENT WITH ID AND NAME WITH PREMEIUM INDICATOR");
	}
	
	public List<EquipmentDAO> findEquipments() {
		List<EquipmentDAO> list = new ArrayList<>();
		EquipmentDAO equipmentDAO = new EquipmentDAO();
		equipmentDAO.setId("ID-001");
		equipmentDAO.setName("Phone");
		list.add(equipmentDAO);
		
		equipmentDAO = new EquipmentDAO();
		equipmentDAO.setId("ID-002");
		equipmentDAO.setName("SIM");
		list.add(equipmentDAO);
		
		equipmentDAO = new EquipmentDAO();
		equipmentDAO.setId("ID-003");
		equipmentDAO.setName("Charger");
		list.add(equipmentDAO);
		
		return list;
	}
	
	public void deleteEquipment(EquipmentDAO equipmentDAO) throws Exception {
		throw new RuntimeException("Equipment Not Found to Delete!!!");
	}
}
