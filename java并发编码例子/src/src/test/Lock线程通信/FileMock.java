package test.Lock�߳�ͨ��;

import java.nio.Buffer;
/**
 * �ļ���
 * @author yangfeng
 *
 */
public class FileMock {
	//�洢����
	private String [] content;
	//������ļ���ȡ���ݵ��к�
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
