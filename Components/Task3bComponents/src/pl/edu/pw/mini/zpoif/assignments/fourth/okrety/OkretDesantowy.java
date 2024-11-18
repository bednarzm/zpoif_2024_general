package pl.edu.pw.mini.zpoif.assignments.fourth.okrety;

public class OkretDesantowy extends Okret {

	protected float zanurzenie;

	public OkretDesantowy(String nazwa, int wypornosc, float dlugosc, int zasieg, int predkosc, int mocNapedu,
			float zanurzenie) {
		super(nazwa, wypornosc, dlugosc, zasieg, predkosc, mocNapedu);
		this.zanurzenie = zanurzenie;
	}

	public float getZanurzenie() {
		return zanurzenie;
	}

}
