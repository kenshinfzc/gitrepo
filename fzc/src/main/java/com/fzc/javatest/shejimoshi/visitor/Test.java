package com.fzc.javatest.shejimoshi.visitor;

public class Test {

	public static void main(String[] args) {
		Employees mEmployees = new Employees();

		mEmployees.addEmployee(new Employee("Tom", 4500, 8, 1));
		mEmployees.addEmployee(new Employee("Jerry", 6500, 10, 2));
		mEmployees.addEmployee(new Employee("Jack", 9600, 12, 3));
		mEmployees.showInfo();
		mEmployees.payFee();
	}
}
