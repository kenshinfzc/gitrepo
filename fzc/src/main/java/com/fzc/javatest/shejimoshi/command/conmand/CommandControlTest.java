package com.fzc.javatest.shejimoshi.command.conmand;

import com.fzc.javatest.shejimoshi.command.OldControl;
import com.fzc.javatest.shejimoshi.command.device.Light;
import com.fzc.javatest.shejimoshi.command.device.Stereo;

/*
 命令模式：
 	将请求、命令、动作等封装成对象，这样可以让项目使用这些对象来参数化其他对象。使得命令的请求者和执行者解耦
适用场景：
 	向某些对象发送请求，但是并不知道请求的接受者是谁，也不知道请求的操作是什么；让程序运行的任何时刻去调用这个方法； 
	将一个请求封装为一个对象，从而使你可以用不同的请求对客户进行参数化 
 优点：
 	调用方与提供方的解耦，扩展性好，对于调用方而言，只调用命令对象的统一执行方法，不需要知道提供方的具体方法
 缺点：
 	每个方法都要封装一个命令对象，复杂场景下代码量较大
 宏命令：MultiCommand
 	宏命令对象封装多个命令对象，依次执行多种命令
 */
public class CommandControlTest {

	public static void main(String[] args) {
		Light l = new Light("bedroom");
		Light l1 = new Light("frontdoor");
		Stereo s = new Stereo("bedroom");
		
		LightOnCommand lo = new LightOnCommand(l);
		LightOnCommand lo1 = new LightOnCommand(l1);
		StereoOnCommand so = new StereoOnCommand(s);
		
		LightOffCommand lof = new LightOffCommand(l);
		LightOffCommand lof1 = new LightOffCommand(l1);
		StereoOffCommand sof = new StereoOffCommand(s);
		
		MultiCommand m = new MultiCommand(l, s);
		
		CommandControl cc = new CommandControl();
		cc.setCommand(0, lo, lof);
		cc.setCommand(1, lo1, lof1);
		cc.setCommand(2, so, sof);
		cc.onButton(0);
//		cc.offButton(0);
		cc.undoButton(0);
		cc.onButton(1);
//		cc.offButton(1);
		cc.undoButton(1);
		cc.onButton(2);
//		cc.offButton(2);
		cc.undoButton(2);
		System.out.println("----------------");
		cc.setCommand(4, m, new NoCommand());
		cc.onButton(4);
		cc.undoButton(4);
		
		
	}

}
