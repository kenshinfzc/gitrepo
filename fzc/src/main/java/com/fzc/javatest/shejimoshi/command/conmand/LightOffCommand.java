package com.fzc.javatest.shejimoshi.command.conmand;

import com.fzc.javatest.shejimoshi.command.device.Light;

public class LightOffCommand implements Command {
	private Light light ;
	public LightOffCommand(Light light ) {
		this.light = light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.lightOff();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		light.lightOn();
	}

}
