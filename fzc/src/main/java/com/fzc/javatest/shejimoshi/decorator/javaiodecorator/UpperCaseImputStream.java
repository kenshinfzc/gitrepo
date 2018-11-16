package com.fzc.javatest.shejimoshi.decorator.javaiodecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*  --daiding
 java内置装饰者模式  io流
    继承FilterInputStream
 */
public class UpperCaseImputStream extends FilterInputStream{

	protected UpperCaseImputStream(InputStream in) {
		super(in);
	}

	public int read() throws IOException
	{
		int c=super.read();
		return c==-1?c:Character.toUpperCase((char)(c));
	}
	public int read(byte[] b,int offset,int len) throws IOException
	{
		int result=super.read(b,offset,len);
		for(int i=0;i<result;i++)
		{
			b[i]=(byte)Character.toUpperCase((char)(b[i]));
		}
		
		return result;
	}
	


}
