package com.fzc.javatest.shejimoshi.decorator.javaiodecorator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		testByteRead();
//		testRead();

	}
	
	private static void testRead() {
		do {
			InputStream is = new UpperCaseImputStream(new BufferedInputStream(System.in));
			try {
				System.out.println((char)is.read());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (true);
	}

	public static void testByteRead(){
		int c;
		try {
			InputStream in = new UpperCaseImputStream(new BufferedInputStream(
					new FileInputStream(new File("test.txt"))));
			while((c=in.read())>=0)
			{
				System.out.print((char)c);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
