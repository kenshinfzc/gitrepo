package com.fzc.javatest.shejimoshi.compose;

import java.util.Iterator;
import java.util.Stack;

public class ComposeIterator implements Iterator {
	private Stack<Iterator> stack = new Stack<Iterator>();

	public ComposeIterator(Iterator iterator) {
		stack.push(iterator);
	}

	@Override
	public boolean hasNext() {

		if (stack.empty()) {
			return false;
		}
		Iterator iterator = stack.peek();
		if (!iterator.hasNext()) {
			stack.pop();
			return hasNext();
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		if (hasNext()) {
			Iterator iterator = stack.peek();
			MenuComponent mMenuComponent = (MenuComponent) iterator.next();
			//将获取对象的迭代器传入堆栈，实现对于子菜单的数据遍历
			//菜单项的迭代器也会放入堆栈，但是hasNext为false，会在判断时直接被弹出
			stack.push(mMenuComponent.getIterator());
			return mMenuComponent;
		}
		return null;
	}

	@Override
	public void remove() {


	}

}
