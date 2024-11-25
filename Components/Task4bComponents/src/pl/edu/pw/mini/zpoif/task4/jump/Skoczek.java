package pl.edu.pw.mini.zpoif.task4.jump;

import pl.edu.pw.mini.zpoif.task4.equipment.Wysokosciomierz;
import pl.edu.pw.mini.zpoif.task4.parachute.ZestawSpadochronowy;

public abstract class Skoczek {

	private static String MOTTO_DOMYSLNE = "Bedzie dobrze!";

	protected String motto = "Skakac, skakac!";

	protected int iloscSkokow;
	protected ZestawSpadochronowy zestawSpadochronowy = new ZestawSpadochronowy();
	private Wysokosciomierz wysokosciomierz;
	protected Noz noz = new Noz();
	protected Gogle gogle = new Gogle();

	private static class Noz {
		private boolean naostrzony;
	}

	private static class Gogle {
		private boolean czyste;
	}

	public Skoczek(Wysokosciomierz wysokosciomierz) {
		super();
		this.wysokosciomierz = wysokosciomierz;
	}

}
