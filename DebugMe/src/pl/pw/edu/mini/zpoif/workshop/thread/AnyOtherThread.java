package pl.pw.edu.mini.zpoif.workshop.thread;

public class AnyOtherThread extends Thread {

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("I am any other thread and doing something...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
