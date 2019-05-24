package test.电影院售票场景模拟;

public class CTest {
	
	public static void main(String[] args) {
		//电影院对象
		Cinema cinema = new Cinema();
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
		Thread thread = new Thread(ticketOffice1,"TicketOffice1");
		
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");
		
		thread.start();
		thread2.start();
		
		try {
			thread.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Cinemal1的余票数:"+cinema.getVacanciesCinema1());
		System.out.println("Cinemal2的余票数:"+cinema.getVacanciesCinema2());
	}
}
