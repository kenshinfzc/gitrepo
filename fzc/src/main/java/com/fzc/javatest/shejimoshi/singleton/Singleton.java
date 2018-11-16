package com.fzc.javatest.shejimoshi.singleton;

/*
 单例模式使用场景：对于只应改存在一个的类通常使用单例模式
 */
public class Singleton {
	//设置私有属性 唯一实例
	private static Singleton uniqueInstance = null;
	//设置私有构造函数，杜绝外部new多个对象
	private Singleton(){
		
	}
	
	//通过静态方法获取实例
	public static Singleton getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}

	/*多线程同时调用该方法产生多个实例问题解决
	1、synchronized 设置同步锁，     缺点：每次调用都是进入同步区域，同步锁消耗资源,不适合调用次数多的场景
		public static synchronized Singleton getInstance()
	2、急切创建实例    缺点：没有被调用的场景也新建的对象，浪费内存
		private static Singleton uniqueInstance = new Singleton();
	3、双重检查加锁      有点：同步块只进入一次，消耗资源少
		private static Singleton uniqueInstance = null;
		
		public static Singleton getInstance(){
		if(uniqueInstance == null){
			synchronized(Singleton.class){
				if(uniqueInstance == null){
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
	*/
}
