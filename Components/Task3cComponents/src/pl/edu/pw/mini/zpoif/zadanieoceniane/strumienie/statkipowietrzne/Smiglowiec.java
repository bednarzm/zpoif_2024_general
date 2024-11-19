package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne;

public class Smiglowiec extends NapedzanyStatekPowietrzny {
	
	protected Double srednicaWirnika;

	public Smiglowiec(String typ, int masa, int zasieg, double predkoscWznoszenia, double srednicaWirnika) {
		super(typ, masa, zasieg, predkoscWznoszenia);
		this.srednicaWirnika = srednicaWirnika;
	}

	public Double getSrednicaWirnika() {
		return srednicaWirnika;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(srednicaWirnika);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Smiglowiec other = (Smiglowiec) obj;
		if (Double.doubleToLongBits(srednicaWirnika) != Double.doubleToLongBits(other.srednicaWirnika))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Smiglowiec [srednicaWirnika=" + srednicaWirnika + ", zasieg=" + zasieg + ", predkoscWznoszenia="
				+ predkoscWznoszenia + ", typ=" + typ + ", masa=" + masa + "]";
	}
	
}
