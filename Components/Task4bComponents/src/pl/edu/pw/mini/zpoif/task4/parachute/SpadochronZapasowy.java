package pl.edu.pw.mini.zpoif.task4.parachute;

public class SpadochronZapasowy extends Spadochron {

	private static abstract class AutomatSpadochronowy {
		private boolean wlaczony;
		private int wysokoscDzialania = 500;
		protected SpadochronZapasowy spadochronZapasowy;

		protected void otworzSpadochron() {
			spadochronZapasowy.otworz();
		}
		
	}

	//Nazwy handlowe celowo zmienione
	private class AutomatVigal extends AutomatSpadochronowy {
		
	}

	//Nazwy handlowe celowo zmienione
	private class AutomatCyprus extends AutomatSpadochronowy {
		
	}

	@Override
	protected void otworz() {
		System.out.println("Spadochron zapasowy otwarty");
	}

}
