package pl.edu.pw.mini.zpoif.assignments.fourth.okrety;

public abstract class Okret {

	protected String nazwa;
	protected Integer wypornosc;
	protected float dlugosc;
	protected int zasieg;
	protected Integer predkosc;
	protected int mocNapedu;

	public Okret(String nazwa, Integer wypornosc, float dlugosc, int zasieg, Integer predkosc, int mocNapedu) {
		super();
		this.nazwa = nazwa;
		this.wypornosc = wypornosc;
		this.dlugosc = dlugosc;
		this.zasieg = zasieg;
		this.predkosc = predkosc;
		this.mocNapedu = mocNapedu;
	}

	public String getNazwa() {
		return nazwa;
	}

	public Integer getPredkosc() {
		return predkosc;
	}

	public Integer getWypornosc() {
		return wypornosc;
	}

	public int getMocNapedu() {
		return mocNapedu;
	}

	public float getDlugosc() {
		return dlugosc;
	}

	public int getZasieg() {
		return zasieg;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(dlugosc);
		result = prime * result + mocNapedu;
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result + ((predkosc == null) ? 0 : predkosc.hashCode());
		result = prime * result + ((wypornosc == null) ? 0 : wypornosc.hashCode());
		result = prime * result + zasieg;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Okret other = (Okret) obj;
		if (Float.floatToIntBits(dlugosc) != Float.floatToIntBits(other.dlugosc))
			return false;
		if (mocNapedu != other.mocNapedu)
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		if (predkosc == null) {
			if (other.predkosc != null)
				return false;
		} else if (!predkosc.equals(other.predkosc))
			return false;
		if (wypornosc == null) {
			if (other.wypornosc != null)
				return false;
		} else if (!wypornosc.equals(other.wypornosc))
			return false;
		if (zasieg != other.zasieg)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
