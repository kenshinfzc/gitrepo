package com.fzc.javatest.xiancheng.piped;

import java.io.PipedWriter;

public class PipedWriterThread extends Thread {
	private PipedWriter pw ;
	private String[] names = new String[]{
			"楚大胖","胖胖胖","小芬芬","哈哈哈"
	};
	
	public PipedWriterThread(PipedWriter pw) {
		// TODO Auto-generated constructor stub
		this.pw = pw;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<10;i++){
				pw.write(names[i%4]+"\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(pw != null){
					pw.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}

}
