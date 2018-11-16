package com.fzc.javatest.shejimoshi.compose;

/*
 组合模式：
 	将对象聚合成树形结构来表现  “整体/部分” 的层次结构。
	组合模式能让客户以一致的方式来处理个别对象以及对象组合。
	也就是我们可以忽略对象组合与个体对象之间的差别
 	将叶子节点与组件节点抽象成统一的类，实现在访问时的相同处理；
 组合迭代器：
 	通过组合模式使得包含复杂结构的数据按照一致的方式来遍历；
 */
public class ComposeIteratorTest {
	public static void main(String[] args) {
		Waitress mWaitress = new Waitress();
		CakeHouseMenu mCakeHouseMenu = new CakeHouseMenu();
		DinerMenu mDinerMenu = new DinerMenu();
		mWaitress.addComponent(mCakeHouseMenu);
		mWaitress.addComponent(mDinerMenu);
		mWaitress.printVegetableMenu();;
	}
}
