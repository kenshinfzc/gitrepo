package com.fzc.javatest.shejimoshi.facade;

import com.fzc.javatest.shejimoshi.facade.hometheater.AirConditon;
import com.fzc.javatest.shejimoshi.facade.hometheater.HomeTheaterFacade;
import com.fzc.javatest.shejimoshi.facade.hometheater.Light;
import com.fzc.javatest.shejimoshi.facade.hometheater.Stereo;
import com.fzc.javatest.shejimoshi.facade.hometheater.TV;

/*
 外观模式：
 	提供一个总的接口，访问子系统中的一群功能
 优点：
 	实现调用方与提供方的逻辑解耦，需要扩展时只需要修改外观类
 与命令模式比较：
 	命令模式侧重于对象、命令的封装，采用更统一的命令类来实现不同方法的统一调用
 	外观模式侧重于方法的整合，通过调用一个总的方法实现一组方法的统一调用
 */

public class FacadeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Light l = new Light();
		AirConditon ac = new AirConditon();
		TV t = new TV();
		Stereo s = new Stereo();
		 l.lightOn();ac.airConditionOn();t.tvOn();s.stereoOn();
		 s.stereoOff();t.tvOff();ac.airConditionOff();l.lightOff();
		 
		 System.out.println("-------------");
		 //外观模式
		 HomeTheaterFacade htf = new HomeTheaterFacade(l, ac, t, s);
		 htf.theaterOn();
		 htf.theaterOff();
	}

}
