package com.fzc.javatest.shejimoshi.agent.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/*
 RMI:远程方法调用
 	1、定义远程接口，作为远端和本地的沟通桥梁
 	2、远程对象实现接口，并注册到rmi服务器
 	3、本地从rmi服务器获取远程对象直接操作
 注意事项：
 	远程传递的对象需要序列化    extends Serializable
 	接口方法需要显式抛出RemoteException异常
 */
public class MyRemoteClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1:6600/remoteTest");
			String s = service.sayHello();
			System.out.println(s);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
