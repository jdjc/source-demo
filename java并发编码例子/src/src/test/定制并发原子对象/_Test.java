package test.定制并发原子对象;

public class _Test {
	public static void main(String[] args) {
		ParkingCounter counter = new ParkingCounter(5);
		Sensor1 sensor1 = new Sensor1(counter);
		Sensor2	 sensor2 = new Sensor2(counter);
		
		Thread thread1= new Thread(sensor1);
		Thread thread2= new Thread(sensor2);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end 实际的值"+counter.get());
		System.out.println("-------------end------------------");
	}
}
