package com.fzc.javatest.xiancheng.piped;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//创建管道输入、输出流
		PipedReader pr = new PipedReader();
		PipedWriter pw = new PipedWriter();
		//连接输入输出流
		pr.connect(pw);
		
		new PipedReaderThread(pr).start();
		new PipedWriterThread(pw).start();
	}

}
