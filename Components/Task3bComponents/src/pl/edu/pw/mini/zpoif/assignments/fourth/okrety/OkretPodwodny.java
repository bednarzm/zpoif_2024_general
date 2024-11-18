package pl.edu.pw.mini.zpoif.assignments.fourth.okrety;

/**
 * @author mabd
 *
 */
public class OkretPodwodny extends Okret {

	protected int liczbaTorped;
	protected boolean posiadaMiny;

	public OkretPodwodny(String nazwa, int wypornosc, float dlugosc, int zasieg, int predkosc, int mocNapedu,
			int liczbaTorped, boolean posiadaMiny) {
		super(nazwa, wypornosc, dlugosc, zasieg, predkosc, mocNapedu);
		this.liczbaTorped = liczbaTorped;
		this.posiadaMiny = posiadaMiny;
	}

	public int getLiczbaTorped() {
		return liczbaTorped;
	}

	public boolean isPosiadaMiny() {
		return posiadaMiny;
	}

}
