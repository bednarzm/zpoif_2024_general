package pl.edu.pw.mini.zpoif.ticker;

public class Ticker {

	public static void main(String[] args) throws InterruptedException {
		int number = 0;
		while(true) {
			System.out.println("Tick - " + number++);
			Thread.sleep(1000);
		}
	}

}
