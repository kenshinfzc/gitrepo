package com.fzc.javatest.fanxing;

import java.util.List;
import java.util.Map;




public class TestFanxing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * ����ͨ���
	 * �������Ϳ���Ϊ��������͵��б�
	 * a����b��������ͣ�List<a> ���� List<b> �������ͣ�����������ͨ���
	 * @param l
	 */
	public void test(List<?> l){
		
	}
	/**
	 * ͨ�������
	 * ����ֻ����First���������б�
	 */
	public void test1 (List<? extends First> l){
		
	}
	/**
	 * ���ͷ���
	 * @param l
	 */
	public <T> void test2(List<T> l,Map<String, T> m){
		
	}

}
