package test.�ڼ��ϵ�ͬ��;

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
			throw new Exception("����Խ��");
		}
	}
	public int [] getData(){
		return data;
	}
}
