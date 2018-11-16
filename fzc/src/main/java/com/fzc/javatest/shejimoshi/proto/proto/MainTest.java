package com.fzc.javatest.shejimoshi.proto.proto;

import java.util.Random;

import com.fzc.javatest.shejimoshi.proto.EventTemplate;

/*
 原型模式：通过复制现有实例来创建新的实例，无须知道相应类的信息
优点：
	  使用原型模式创建对象比直接new一个对象更有效
	  隐藏制造新实例的复杂性
	  重复地创建相似对象时可以考虑使用原型模式
缺点：
	  每一个类必须配备一个克隆方法
	  深层复制比较复杂
注意事项：
  	使用原型模式复制对象不会调用类的构造方法。所以，单例模式与原型模式是冲突的，在使用时要特别注意。
  	Object类的clone方法只会拷贝对象中的基本的数据类型，对于数组、容器对象、引用对象等都不会拷贝，这就是浅拷贝。如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另行拷贝。
适用场合：
	  复制对象的结构与数据
	  希望对目标对象的修改不影响既有的原型对象
	  创建对象成本较大的情况下
 */
public class MainTest {
	public static void main(String[] args) {
		int i = 0;
		int MAX_COUNT = 10;
		EventTemplate et = new EventTemplate("9月份信用卡账单", "国庆抽奖活动...");

		Mail mail = new Mail(et);
		mail.getArr().add("11");
		mail.getArr().add("22");

		while (i < MAX_COUNT) {
			// 以下是每封邮件不同的地方
			Mail cloneMail = (Mail) mail.clone();
			cloneMail.setContent(getRandString(5) + ",先生（女士）:你的信用卡账单..."
					+ cloneMail.getTail());
			cloneMail.setReceiver(getRandString(5) + "@" + getRandString(8) + ".com");
			// 然后发送邮件
			sendMail(cloneMail);
			i++;
		}

	}

	public static String getRandString(int maxLength) {
		String source = "abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		for (int i = 0; i < maxLength; i++) {
			sb.append(source.charAt(rand.nextInt(source.length())));
		}
		return sb.toString();
	}

	public static void sendMail(Mail mail) {
		System.out.println("标题：" + mail.getSubject() + "\t收件人："
				+ mail.getReceiver() + "\t内容：" + mail.getContent()
				+ "\t....发送成功！"+"--arr:"+mail.getArr().toString());
	}

}
