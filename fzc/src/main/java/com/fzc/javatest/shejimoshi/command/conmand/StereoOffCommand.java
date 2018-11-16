package com.fzc.javatest.shejimoshi.command.conmand;

import com.fzc.javatest.shejimoshi.command.device.Stereo;

public class StereoOffCommand implements Command {
	private Stereo stereo; 
	public StereoOffCommand( Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.stereoOff();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		stereo.stereoOn();
	}

}
