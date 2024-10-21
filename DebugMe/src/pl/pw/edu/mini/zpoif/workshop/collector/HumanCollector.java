package pl.pw.edu.mini.zpoif.workshop.collector;

import java.util.ArrayList;
import java.util.List;

public class HumanCollector {

	private List<Human> generatedHumans = new ArrayList<>();

	/**
	 * UWAGA. W kodzie znajduja sie celowo popelnione bugi zeby bylo co debugowac.
	 */
	public void go() {
		boolean go = true;
		int newHumanNumber = 0;
		
		while (go) {
			try {
				System.out.print("Czy dodana zostanie nowa osoba?");
				if (generatedHumans.size() < 20) {
					Human newHuman = new Human();
					for (int i = 0; i < newHumanNumber; i++) {
						if (generatedHumans.contains(newHuman)) {
							generatedHumans.add(new Human());
							System.out.print("Dodano " + newHuman + "; ");
						}
					}
				}

				System.out.println();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Koniec dodawania. Dodano: " + generatedHumans.size() + " ludzi.");
	}

}
