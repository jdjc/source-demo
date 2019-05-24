package test.Lock线程通信;

import java.nio.Buffer;
/**
 * 文件类
 * @author yangfeng
 *
 */
public class FileMock {
	//存储内容
	private String [] content;
	//从这个文件读取内容的行号
	private int index;
	public FileMock(int size,int length) {
	 content = new String[size];
	 for(int i =0; i<size;i++){
		 StringBuffer stringBuffer =new StringBuffer(length);
		 for(int j=0;j<length;j++){
			 int indice=(int)Math.random()*255;
			 stringBuffer.append((char)indice);
		 }
		 content[i] = stringBuffer.toString();
	 }
	 index =0;
	}
	public boolean hasMoreLines(){
		return index<content.length;
	}
	public String getLine(){
		if(this.hasMoreLines()){
			System.out.println("Mock : "+ (content.length -index));
			return content[index++];
		}
		return null;
	}
	
	
}
