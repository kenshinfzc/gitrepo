package com.fzc.javatest.zhengze;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Pattern p = Pattern.compile("ae");
		Matcher m = p.matcher("aaef1hu2ae23jf");
		Boolean b = m.matches();
		
		while(m.find()){
			System.out.println(m.group());
			System.out.println(m.start());
			System.out.println(m.end());
			System.out.println("---------");
		}*/
		
		Scanner s = new Scanner(System.in);
		System.out.println("������������ʽ��");
		String reg = s.nextLine();
//		System.out.println(reg+"\n");
		System.out.println("������Ҫƥ����ַ�����");
		String Str = s.nextLine();
//		System.out.println(Str+"\n");
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(Str);
		System.out.println("�ַ�����"+Str+"\n����"+reg);
		while(m.find()){
			System.out.println("ƥ���λ�ã�"+m.start()+"-"+(m.end()-1));
		}
		
		
		
		
	}

}
