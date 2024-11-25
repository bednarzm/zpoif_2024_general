package pl.edu.pw.mini.zpoif.task4.jump;

import java.util.Random;

import pl.edu.pw.mini.zpoif.task4.equipment.Wysokosciomierz;

public class Egzaminator extends Instruktor {

	public Egzaminator(Wysokosciomierz wysokosciomierz) {
		super(wysokosciomierz);
		iloscSkokow = new Random().nextInt(1000) + 1000;
	}

}
