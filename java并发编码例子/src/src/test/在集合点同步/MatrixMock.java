package test.在集合点同步;

import java.util.Random;

public class MatrixMock {
	private  int data [][];
	//矩阵的行数，每行的宽度，要寻找到数字
	public MatrixMock(int size,int length,int number) {
		int count=0;
		data = new int[size][length];
		Random random = new Random();
		for(int i =0;i<size;i++){
			for(int j =0;j<length;j++){
				data[i][j] = random.nextInt(10);
				if(data[i][j] ==number){
					count++;
				}
			}
		}
		System.out.println("查询结果："+number+"共出现了"+count+"次！");
	}
	/**
	 * 获取矩阵中一行的信息
	 * @param row
	 * @return
	 */
	public int [] getRow (int row){
		if(row>=0 && row<data.length){
			return data[row];
		}
		return null;
	}
}