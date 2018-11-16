package com.fzc.javatest.shejimoshi.visitor.visitor;

public class ConcreteVisitor implements Visitor {

	@Override
	public void visit(Element element) {
		// TODO Auto-generated method stub
		Employee employee = (Employee) element;
		System.out.println("employee name:"+employee.getName()+",pay fee:"+employee.getVacationDays()*employee.getIncome()*employee.getDegree());
	}

}
