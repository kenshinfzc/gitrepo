package com.fzc.javatest.shejimoshi.adapter;

import com.fzc.javatest.shejimoshi.adapter.adapter.DuckAdapter;
import com.fzc.javatest.shejimoshi.adapter.adapter.DuckAdapterClass;
import com.fzc.javatest.shejimoshi.adapter.duck.Duck;
import com.fzc.javatest.shejimoshi.adapter.duck.RedHeadDuck;
import com.fzc.javatest.shejimoshi.adapter.turkey.Turkey;
import com.fzc.javatest.shejimoshi.adapter.turkey.WildTurkey;

/*
 适配器模式：
 	将一个类的接口转换成另一个接口，保证接口的兼容性
 优点：
 	从用户的角度看不到被适配者，是解耦的
	用户调用适配器转化出来的目标接口方法
	适配器再调用被适配者的相关接口方法
	用户收到反馈结果，感觉只是和目标接口交互
适用场景：
	1、系统需要使用现有的类，而这些类的接口不符合系统的需要。 
	2、 想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作。 
	3 、需要一个统一的输出接口，而输入端的类型不可预知 
 对象适配器：推荐使用。灵活性高，方便子类替换
 	通过多重继承目标接口和被适配者类方式来实现适配,
 	适配器对象实现被适配的对象的接口，组合适配对象，并实现被适配对象的方法，调用适配对象的方法
 	实际调用时依然调用被适配对象内的方法，通过适配器对象的转换，实际的处理逻辑还是适配的对象中的处理方法
 类适配器：推荐使用。不方便子类替换，需要重新修改继承类
 	继承适配对象，实现被适配对象的接口，适配器对象中实现被适配对象的方法，重写适配对象的方法
 比较：
 	对象适配器和类适配器使用了不同的方法实现适配，对象适配器使用组合，类适配器使用继承
 */
public class AdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Turkey t = new WildTurkey();
		t.display();t.swim();t.fly();t.haha();
		Duck d = new RedHeadDuck();
		d.display();d.fly();d.quack();d.jump();
		Duck da = new DuckAdapter(t);
		da.display();da.fly();da.quack();
		Duck da2 = new DuckAdapterClass();
		da2.display();da2.fly();da2.quack();
	}

}
