package test.ForkJoin�̳߳�;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction{

	/**
	 * ����Ԫ�� ��ΪrecursiveAction�ĸ���ʵ����Serializable�ӿ�
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private int first;
	private int last;
	private double increment;
	public Task(List<Product> list,int first,int last,double increment) {
		this.first = first;
		this.products = list;
		this.last=last;
		this.increment = increment;	
	}
	/**
	 * �����ִ���߼�
	 */
	@Override
	protected void compute() {
		if(last-first<10){
			updatePrices();
		}
		else{
			int middle = (last+first)/2;
			System.out.println("���񳬹� 10���� ��ʼ������");
			Task task1 = new Task(products, first, middle+1, increment);
			Task task2 = new Task(products, middle+1, last, increment);
			invokeAll(task1, task2);
		}
	}
	private void updatePrices() {
		for(int i =first;i<last;i++){
			Product product = products.get(i);
			product.setPrice(product.getPrice()*(1+increment));
		}
	}

}
