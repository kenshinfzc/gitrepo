package com.fzc.javatest.wenjian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import com.mysql.jdbc.Buffer;

public class IOTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		IOTest iot = new IOTest();
//		iot.testByte();
		iot.testChar();
//		iot.testKeyIn();
	}
	
	public void testKeyIn() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String a = null;
		while((a=br.readLine())!=null){
			while(a.equals("exit")){
				System.exit(0);
			}
			System.out.println(a);
		}
		if(br!=null){
			br.close();
		}
	}
	
	public void testByte() throws IOException{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream("FileInput.java");
		
			fos = new FileOutputStream("FileOuput.txt");
			byte[] b= new byte[1024];
			int a = 0;
			while((a=fis.read(b))>0){
				System.out.println(new String(b,0,a));
				fos.write(b,0,a);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				fis.close();
			}
			if(fos!=null){
				fos.close();
			}
		}
	}
	
	public void testChar() throws IOException{
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("FileInput.java");
			fw = new FileWriter("FileOuput.txt");
			char[] b = new char[1024];
			int a = 0;
			while((a=fr.read(b))>0){
				System.out.println(new String(b,0,a));
				fw.write(b,0,a);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fr!=null){
				fr.close();
			}
			if(fw!=null){
				fw.close();
			}
		}
	}
}
