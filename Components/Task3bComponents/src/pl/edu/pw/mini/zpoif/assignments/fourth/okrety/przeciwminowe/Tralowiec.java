package pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe;

public class Tralowiec extends OkretTarczyPrzeciwminowej {
	
	protected boolean tralMalomagnetyczny;

	public Tralowiec(String nazwa, int wypornosc, float dlugosc, int zasieg, int predkosc, int mocNapedu,
			boolean tralMalomagnetyczny) {
		super(nazwa, wypornosc, dlugosc, zasieg, predkosc, mocNapedu);
		this.tralMalomagnetyczny = tralMalomagnetyczny;
	}

	public boolean getTralMalomagnetyczny() {
		return this.tralMalomagnetyczny;
	}
}
