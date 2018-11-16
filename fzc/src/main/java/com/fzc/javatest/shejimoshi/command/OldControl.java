package com.fzc.javatest.shejimoshi.command;

import com.fzc.javatest.shejimoshi.command.device.Light;
import com.fzc.javatest.shejimoshi.command.device.Stereo;

public class OldControl implements Control {
	private Light light ;
	private Stereo stereo;
	public OldControl(Light light ,Stereo stereo) {
		this.light = light;
		this.stereo = stereo;
	}
	

	@Override
	public void onButton(int index) {
		switch (index) {
		case 0:
			light.lightOn();
			break;
		case 1:
			stereo.stereoOn();
			break;
		default:
			break;
		}
	}

	@Override
	public void offButton(int index) {
		switch (index) {
		case 0:
			light.lightOff();
			break;
		case 1:
			stereo.stereoOff();
			break;
		default:
			break;
		}
	}


	@Override
	public void undoButton(int index) {
		// TODO Auto-generated method stub
		
	}

}
