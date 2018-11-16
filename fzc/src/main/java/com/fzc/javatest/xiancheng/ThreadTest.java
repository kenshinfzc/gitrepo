package com.fzc.javatest.xiancheng;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
//		testThread();
//		testRunnable();
//		testRun();
//		testJoin();
//		testDaemon();
//		testYield();
//		testThreadGroup();
	}

	private static void testThreadGroup() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		new GroupTestThread(Thread.currentThread().getThreadGroup(), "线程1").start();
		ThreadGroup tg = new ThreadGroup("新线程组");
		new GroupTestThread(tg, "线程2").start();
	}
	
	private static void testYield() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"  "+i);
			if(i==20){
				//yield()  实际测试发现，并不能通过优先级来控制线程的执行顺序，还是谁抢到谁执行,  //不过优先级高的线程  抢到的概率会比较大
				YieldThread yt = new YieldThread("高级线程");
				yt.setPriority(Thread.MAX_PRIORITY);
				yt.start();
				YieldThread yt2 = new YieldThread("低级线程");
				yt2.setPriority(Thread.MIN_PRIORITY);
				yt2.start();
			}
		}
	}

	private static void testDaemon() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"  "+i);
			if(i==20){
				//后台线程    后台运行，为其他线程提供服务，当所以前台线程全部死亡是，自动死亡
				DaemonThread dt = new DaemonThread("daemonthread");
				dt.setDaemon(true);//设置线程为后台线程
				dt.start();
			}
		}
		
	}

	private static void testJoin() throws InterruptedException {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"  "+i);
			if(i==20){
				//join() 主线程调用jt的join()方法，则要等到jt线程执行完才能继续执行
				JoinThread jt = new JoinThread("被join的线程");
				jt.start();
				jt.join(5);
			}
		}
	}

	private static void testRun() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"  "+i);
			if(i==20){
				//start   run   线程启动用start
				new FirstThread().run();
				new FirstThread().run();
			}
		}
	}

	private static void testRunnable() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"  "+i);
			if(i==20){
				//Runnable接口实现方式，可以通过共享同一个target对象来实现多个线程共享相同的实例属性，使用较多
				SecondThread st = new SecondThread();
				new Thread(st, "secondthread-1").start();
				new Thread(st, "secondthread-2").start();
			}
		}
	}

	private static void testThread() throws InterruptedException {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"  "+i);
			if(i==20){
				//Thread子类方式，多个线程不能共享实例属性
				new FirstThread().start();
				Thread.sleep(1);//设置线程立即执行
				new FirstThread().start();
			}
		}
	}
}
