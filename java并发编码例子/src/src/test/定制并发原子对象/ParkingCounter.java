package test.���Ʋ���ԭ�Ӷ���;

import java.util.concurrent.atomic.AtomicInteger;

import javax.print.attribute.ResolutionSyntax;

public class ParkingCounter extends AtomicInteger{

	/**
	 */
	private static final long serialVersionUID = 1L;

	private int maxNumber;
	
	public ParkingCounter(int maxNumber) {
		set(0);
		this.maxNumber= maxNumber;
	}
	public boolean carIn(){
		for(;;){
			int value =get();
			if(value == maxNumber){
				System.out.println("ֵ�Ѿ�����");
				return false;
			}else{
				int newValue = value+1;
				boolean changed = compareAndSet(value, newValue);
				if(changed){
					System.out.println("�Ѿ��滻��");
					return true;
				}
			}
		}
	}
	public boolean carOut(){
		for(;;){
			int value =get();
			if(value==0){
				return false;
			}else{
				int newValue = value-1;
				boolean changed =compareAndSet(value, newValue);
				if(changed){
					System.out.println("�Ѿ��滻��");
					return true;
				}
			}
		}
	}
}
