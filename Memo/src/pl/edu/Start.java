package pl.edu;

import java.util.LinkedList;
import java.util.List;

public class Start {
	
	private static List<Dummy> dummies = new LinkedList<Dummy>();
	
	private static List<Dummy> create(int n){
		List<Dummy> list = new LinkedList<Dummy>();
		for(int i = 0;i<n;i++) {
			list.add(new Dummy());
		}
		return list;
	}

	public static void main(String[] args) {
		while(true) {
			try {
				System.out.println(" >>> ");
				dummies.addAll(create(10000));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
