import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		IOTest iot = new IOTest();
//		iot.testByte();
		iot.testChar();
	}
	
	public void testByte() throws IOException{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream("FileInput.java");
		
			fos = new FileOutputStream("FileOuput.txt");
			byte[] b= new byte[1024];
			int a = 0;
			while((a=fis.read(b))>0){
				System.out.println(new String(b,0,a));
				fos.write(b,0,a);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				fis.close();
			}
			if(fos!=null){
				fos.close();
			}
		}
	}
	
	public void testChar() throws IOException{
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("FileInput.java");
			fw = new FileWriter("FileOuput.txt");
			char[] b = new char[32];
			while(fr.read(b)>0){
				System.out.println(new String(b));
				fw.write(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fr!=null){
				fr.close();
			}
			if(fw!=null){
				fw.close();
			}
		}
	}
}
