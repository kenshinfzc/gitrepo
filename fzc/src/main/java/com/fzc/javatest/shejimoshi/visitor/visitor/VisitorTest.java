package com.fzc.javatest.shejimoshi.visitor.visitor;

/*
 访问者模式：对于一组对象，在不改变数据结构的前提下，增加作用于这些结构元素新的功能。
适用于数据结构相对稳定，它把数据结构和作用于其上的操作解耦，使得操作集合可以相对自由地演化。
适用场合：
  	如果一个系统有比较稳定的数据结构，又有经常变化的功能需求，那么访问者模式就是比较合适的
优点：
	  符合单一职责原则
	  扩展性良好
	  有益于系统的管理和维护
缺点：
	  增加新的元素类变得很困难
	  破坏封装性

 */
public class VisitorTest {

	public static void main(String[] args) {
		Employees mEmployees = new Employees();

		mEmployees.addEmployee(new Employee("Tom", 4500, 8, 1));
		mEmployees.addEmployee(new Employee("Jerry", 6500, 10, 2));
		mEmployees.addEmployee(new Employee("Jack", 9600, 12, 3));
		mEmployees.accept(new ConcreteVisitor());
	}
}
