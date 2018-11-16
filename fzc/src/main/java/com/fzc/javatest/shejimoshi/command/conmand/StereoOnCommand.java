package com.fzc.javatest.shejimoshi.command.conmand;

import com.fzc.javatest.shejimoshi.command.device.Stereo;

public class StereoOnCommand implements Command {
	private Stereo stereo; 
	public StereoOnCommand( Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.stereoOn();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		stereo.stereoOff();
	}

}
