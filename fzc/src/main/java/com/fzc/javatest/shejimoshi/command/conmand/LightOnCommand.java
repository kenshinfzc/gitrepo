package com.fzc.javatest.shejimoshi.command.conmand;

import com.fzc.javatest.shejimoshi.command.device.Light;

public class LightOnCommand implements Command {
	private Light light ;
	public LightOnCommand(Light light ) {
		this.light = light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.lightOn();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		light.lightOff();
	}

}
