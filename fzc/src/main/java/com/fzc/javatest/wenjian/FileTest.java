package com.fzc.javatest.wenjian;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public FileTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(".");
		System.out.println(file.exists());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		file.createNewFile();
		System.out.println(file.exists());
		Boolean a = file.mkdir();
		System.out.println(a);
		String[] list = file.list();
		for(String f : list){
			System.out.println(f);
		}

	}

}
