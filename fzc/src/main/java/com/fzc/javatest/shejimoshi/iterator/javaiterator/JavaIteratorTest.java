package com.fzc.javatest.shejimoshi.iterator.javaiterator;

/*
 java内置迭代器模式：
 	数组场景，实现java。util.Iterator
 	ArrayList.iterator()
 	HashMap.values().iterator();  HashMap.keySet().iterator() ;
 	hasNext()  next()  remove()(支持删除 )
 */
public class JavaIteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LunchMenu l = new LunchMenu();
		SupperMenu s = new SupperMenu();
		CafeMenu c = new CafeMenu();
		Waiter w = new Waiter(l, s);
		w.addIterator(l.getLunchIterator());
		w.addIterator(s.getSupperIterator());
		w.addIterator(c.getCafeIterator());
		w.addIterator(c.getCafeNameIterator());
		w.printAllMenuItem();
	}

}
