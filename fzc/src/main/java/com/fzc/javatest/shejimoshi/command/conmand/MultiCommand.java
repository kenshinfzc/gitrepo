package com.fzc.javatest.shejimoshi.command.conmand;

import com.fzc.javatest.shejimoshi.command.device.Light;
import com.fzc.javatest.shejimoshi.command.device.Stereo;

public class MultiCommand implements Command {
	private Light l ;
	private Stereo s ;
	public MultiCommand(Light l , Stereo s) {
		this.l = l;
		this.s = s;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		l.lightOn();
		s.stereoOn();
	}

	@Override
	public void undo() {
		l.lightOff();
		s.stereoOff();

	}

}
