package pl.edu.pw.mini.zpoif.task4.jump;

import java.util.Random;

import pl.edu.pw.mini.zpoif.task4.equipment.Wysokosciomierz;

public class Instruktor extends Skoczek {
	public Instruktor() {
		super(new Wysokosciomierz());
	}
	public Instruktor(Wysokosciomierz wysokosciomierz) {
		super(wysokosciomierz);
		iloscSkokow = new Random().nextInt(500) + 500;
	}

}
