package com.fzc.javatest.yichang;


public class TestExceptionChain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws RuntimeException{
		// TODO Auto-generated method stub
		TestExceptionChain t = new TestExceptionChain();
		
//			t.firstMethod();
		t.thirdMethod();
	}
	
	//�쳣��1���·�ʽ
	public void firstMethod(){
		try {
			secondMethod();
		} catch (RuntimeException e) {
			throw new RuntimeException("firstMethod throw exception",e);
		}
	}
	
	public void secondMethod(){
		throw new RuntimeException("secondMethod throw exception");
	}
	
	//�쳣��2���Ϸ�ʽ
	public void thirdMethod(){
		try {
			forthMethod();
		} catch (RuntimeException e) {
			RuntimeException e1 = new RuntimeException("firstMethod throw exception");
			e1.initCause(e);
			throw e1;
		}
	}
	
	public void forthMethod(){
		throw new RuntimeException("forthMethod throw exception");
	}

}
