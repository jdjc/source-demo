package test.ForkJoin�̳߳��кϲ�����Ľ��;

import java.util.Random;

/**
 * 
 * @author yangfeng
 *
 */
public class DocumentMock {
	//��һЩ�ʴ���һ���ַ�������
	private String words [] ={"the","hello","goodbye","packt","java","thread","pool","random","class","main"};
	/**
	 * ����һ���ַ�����ά���飬���Ҳ���work�ؼ���  �����ֵĴ�����ӡ������̨��
	 * @param numLines
	 * @param numWords
	 * @param word
	 * @return
	 */
	public String[][] generateDocument(int numLines,int numWords,String word){
		int counter = 0 ;
		String  document[][] = new String[numLines][numWords];
		Random random = new Random();
		for(int i =0; i<numLines;i++){
			for(int j =0; j<numWords;j++){
				int index = random.nextInt(words.length);
				document[i][j] = words[index];
				if(document[i][j].equals(word)){
					counter++;
				}
			}
		}
		System.out.println("������" +  counter+"�Σ�");
		return  document;
	}
}
