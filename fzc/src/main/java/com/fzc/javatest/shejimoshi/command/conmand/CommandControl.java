package com.fzc.javatest.shejimoshi.command.conmand;

import java.util.Stack;

import com.fzc.javatest.shejimoshi.command.Control;

public class CommandControl implements Control{
	private Stack<Command> s ;
	private Command[] ons;
	private Command[] offs;

	public CommandControl() {
		s = new Stack<Command>();
		ons = new Command[5];
		offs = new Command[5];
		for(int i=0;i<ons.length;i++){
			ons[i]=new NoCommand();
		}
		for(int i=0;i<offs.length;i++){
			offs[i]=new NoCommand();
		}
	}
	
	public void setCommand(int i ,Command on,Command off){
		ons[i] = on;
		offs[i] = off;
	}

	@Override
	public void onButton(int index) {
		// TODO Auto-generated method stub
		ons[index].execute();
		s.push(ons[index]);
	}

	@Override
	public void offButton(int index) {
		// TODO Auto-generated method stub
		offs[index].execute();
		s.push(offs[index]);
	}

	@Override
	public void undoButton(int index) {
		// TODO Auto-generated method stub
		s.pop().undo();
	}

}
