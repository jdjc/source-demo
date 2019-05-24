package test.在集合点同步;

public class Results {
	private int data[];
	public Results(int size){
		data = new int [size];
	}
	public void setData(int index,int value) throws Exception{
		if(index<data.length){
			data[index] = value;
		}
		else{
			throw new Exception("数组越界");
		}
	}
	public int [] getData(){
		return data;
	}
}
