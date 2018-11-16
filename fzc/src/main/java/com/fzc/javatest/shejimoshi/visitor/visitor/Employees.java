package com.fzc.javatest.shejimoshi.visitor.visitor;

import java.util.HashMap;

public class Employees {
	private HashMap<String,Employee> employees ;
	
	public Employees() {
		// TODO Auto-generated constructor stub
		employees = new HashMap<String, Employee>();
	}
	
	public void addEmployee(Employee employee){
		employees.put(employee.getName(), employee);
	}
	
	public Employee getEmployee(String name){
		return employees.get(name);
	}
	
	public void showInfo(){
		for(Employee employee : employees.values()){
			employee.showInfo();
		}
	}

	public void accept(Visitor visitor){
		for(Employee employee : employees.values()){
			employee.accept(visitor);
		}
	}

}
