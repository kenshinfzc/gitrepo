package com.fzc.javatest.shejimoshi.builder;

import com.fzc.javatest.shejimoshi.builder.builder.Builder2Days;
import com.fzc.javatest.shejimoshi.builder.builder.Builder3Days;
import com.fzc.javatest.shejimoshi.builder.builder.BuilderSelf;
import com.fzc.javatest.shejimoshi.builder.vacation.Vacation;

/*
 生成器模式：封装一个复杂对象构造过程，并允许按步骤构造
 优点：
	将复杂对象的创建过程封装起来
	允许对象通过几个步骤来创建，并且可以改变过程（工厂模式只有一个步骤）
	只需指定具体生成器就能生成特定对象，隐藏类的内部结构
	对象的实现可以被替换

生成器模式和抽象工厂模式在功能上很相似，主要区别：
	生成器一般用来创建大的复杂的对象
	生成器模式强调的是一步步创建对象，可以改变步骤来生成不同的对象
	一般来说生成器模式中对象不直接返回

 */
public class BuilderTest {
	public static void main(String[] args) {
		Director d = new Director(new Builder3Days("2017-08-12"));
		Vacation v = d.constructVacation();
		v.showInfo();
		
		d = new Director(new Builder2Days("2017-08-12"));
		v = d.constructVacation();
		v.showInfo();
		
		BuilderSelf bs = new BuilderSelf("2017-08-12");
		bs.addTickets("fly to hefei;").addTickets("bus ticket").addEvents("visit baogongci ;").addEvents("visit baogongmu ;").addHotel("home inn");
		bs.addDay().addTickets("fly to wuhan;").addTickets("bus ticket").addEvents("just walk ;");
		bs.getVacation().showInfo();
		
		Vacation va = new Vacation("2017-08-12");
		va.addTicket("fly to hefei;");
		va.addTicket("bus ticket");va.addEvent("visit baogongci ;");va.addEvent("visit baogongmu ;");va.addHotel("home inn");
		va.addDay();va.addTicket("fly to wuhan;");va.addTicket("bus ticket");va.addEvent("just walk ;");
		va.showInfo();
	}
}
