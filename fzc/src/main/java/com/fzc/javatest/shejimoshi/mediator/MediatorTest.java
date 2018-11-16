package com.fzc.javatest.shejimoshi.mediator;

/*
 中介者模式：用一个中介对象来封装一系列的对象交互。
	中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互
优点：
	  通过将对象彼此解耦，可以增加对象的复用性
	  通过将控制逻辑集中，可以简化系统维护
	  可以让对象之间所传递的消息变得简单而且大幅减少
	  提高系统的灵活性，使得系统易于扩展和维护
缺点：
	  中介者承担了较多的责任，一旦中介者出现了问题，整个系统就会受到影响
	  如果设计不当，中介者对象本身变得过于复杂
适用场合：
	  一组对象之间的通信方式比较复杂，导致相互依赖，结构混乱
	  一个对象引用很多其他对象并直接与这些对象通信，导致难以复用该对象
中介者模式和外观模式
	中介者模式关注内部对象之间的相互调用
	外观模式关注外部对象对内部对象的统一调用
  中介者模式和观察者模式
  	中介者模式 一般通过 观察者模式 实现
	协同者 作为 发布者，中介者 作为 观察者
	协同者 发布消息 -> 中介者 收到并处理消息 -> 中介者 直接发送消息给 协同者
	协同者 不依赖于 中介者
	当组件之间依赖关系简单时，可以直接使用 观察者模式
	当组件之间依赖关系复杂是，需要借助 中介者模式 梳理关系
 */
public class MediatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcreteMediator mediator = new ConcreteMediator();
		Alarm alarm = new Alarm("ala", mediator);
		Coffee coffee = new Coffee("cof", mediator);
		TV tv = new TV("tv", mediator);
		alarm.sendAlarm(1);
	}

}
