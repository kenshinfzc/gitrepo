package com.fzc.javatest.shejimoshi.command;

import com.fzc.javatest.shejimoshi.command.device.Light;
import com.fzc.javatest.shejimoshi.command.device.Stereo;

public class ControlTest {
	public static void main(String[] args){
		Light l = new Light("bedroom");
		Stereo s = new Stereo("bedroom");
		OldControl oc = new OldControl(l, s);
		oc.onButton(0);
		oc.onButton(1);
		oc.offButton(0);
		oc.offButton(1);
		
	}
}
