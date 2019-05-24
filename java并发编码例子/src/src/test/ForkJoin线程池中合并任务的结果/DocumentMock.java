package test.ForkJoin线程池中合并任务的结果;

import java.util.Random;

/**
 * 
 * @author yangfeng
 *
 */
public class DocumentMock {
	//用一些词创建一个字符串数组
	private String words [] ={"the","hello","goodbye","packt","java","thread","pool","random","class","main"};
	/**
	 * 创建一个字符串二维数组，并且查找work关键字  将出现的次数打印到控制台上
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
		System.out.println("出现了" +  counter+"次！");
		return  document;
	}
}
