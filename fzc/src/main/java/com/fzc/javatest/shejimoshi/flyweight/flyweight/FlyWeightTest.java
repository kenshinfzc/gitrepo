package com.fzc.javatest.shejimoshi.flyweight.flyweight;

/*
 蝇量模式：通过共享的方式高效地支持大量细粒度的对象。
优点：
	减少运行时的对象实例个数，节省创建开销和内存
	将许多“虚拟”对象的状态集中管理
缺点：
	系统设计更加复杂
	需要专门维护对象的外部状态
适用场合：
	需要大量细粒度对象
	这些对象的外部状态不多
	按照内部状态分成几个组，每一个组都仅用一个蝇量对象代替
 */
public class FlyWeightTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMemInfo();
		TreeManager tm = new TreeManager();
		showMemInfo();
		tm.display();
		showMemInfo();
	}

	public static void showMemInfo() {
		// 最大内存：
		long max = Runtime.getRuntime().maxMemory();
		// 分配内存：
		long total = Runtime.getRuntime().totalMemory();
		// 已分配内存中的剩余空间 ：
		long free = Runtime.getRuntime().freeMemory();
		// 已占用的内存：
		long used = total - free;

		System.out.println("最大内存 = " + max);
		System.out.println("已分配内存 = " + total);
		System.out.println("已分配内存中的剩余空间 = " + free);
		System.out.println("已用内存 = " + used);
		System.out.println("时间 = " + System.currentTimeMillis());
		System.out.println("");

	}
}
