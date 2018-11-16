package com.fzc.javatest.shejimoshi.bridge.bridge;

import com.fzc.javatest.shejimoshi.bridge.LGTvControl;
import com.fzc.javatest.shejimoshi.bridge.SharpTvControl;
import com.fzc.javatest.shejimoshi.bridge.SonyTvControl;

/*
 桥接模式：将实现（TVControl）和抽象（Control）放在两个不同的类层次里，是两个层次可以独立变化，
 	实现中引用抽象的接口，便于扩展，桥接的目的是分离抽象与实现，使抽象和实现可以独立变化
 适用场景：
 	系统有多维角度分类时，而每一种分类又有可能变化，考虑使用桥接模式
与策略模式的比较：
	桥接的目的是让底层实现和上层接口可以分别演化，从而提高移植性
	策略的目的是将复杂的算法封装起来，从而便于替换不同的算法
	桥接模式是往往是为了利用已有的方法或类
	策略模式是为了扩展和修改，并提供动态配置
	桥接模式强调接口对象仅提供基本操作
	策略模式强调接口对象提供的是一种算法
 	
 */
public class BridgeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TVControl tv = new TVControl(new SonyTvControl());
		tv.onOff();tv.preChannel();tv.nextChannel();
		
		tv = new TVControl(new LGTvControl());
		tv.onOff();tv.preChannel();tv.nextChannel();
		
		tv = new TVControl(new SharpTvControl());
		tv.onOff();tv.nextChannel();tv.preChannel();
		tv.backChannel();tv.backChannel();
		
		
	}

}
