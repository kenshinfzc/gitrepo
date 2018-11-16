package com.fzc.javatest.xiancheng.piped;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

public class PipedReaderThread extends Thread {
	private PipedReader pr;
	private BufferedReader br;
	
	public PipedReaderThread(PipedReader pr) {
		// TODO Auto-generated constructor stub
		br = new BufferedReader(pr);
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String s = "";
		try {
			while ((s=br.readLine())!=null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br != null){
					br.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
