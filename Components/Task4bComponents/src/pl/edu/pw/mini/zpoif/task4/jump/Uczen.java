package pl.edu.pw.mini.zpoif.task4.jump;

import java.util.Random;

import pl.edu.pw.mini.zpoif.task4.equipment.SygnalizatorWysokosci;
import pl.edu.pw.mini.zpoif.task4.equipment.Wysokosciomierz;

public class Uczen extends Skoczek {

	private SygnalizatorWysokosci sygnalizatorWysokosci = new SygnalizatorWysokosci();

	public Uczen(Wysokosciomierz wysokosciomierz) {
		super(wysokosciomierz);
		iloscSkokow = new Random().nextInt(10);
	}

}
