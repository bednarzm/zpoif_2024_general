package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne;

public class Spadochron extends StatekPowietrzny {
	
	protected double powierzchnia;
	protected Integer dopuszczalnaMasaSkoczka;
	
	public Spadochron(String typ, int masa, double powierzchnia, int dopuszczalnaMasaSkoczka) {
		super(typ, masa);
		this.powierzchnia = powierzchnia;
		this.dopuszczalnaMasaSkoczka = dopuszczalnaMasaSkoczka;
	}

	public double getPowierzchnia() {
		return powierzchnia;
	}

	public Integer getDopuszczalnaMasaSkoczka() {
		return dopuszczalnaMasaSkoczka;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dopuszczalnaMasaSkoczka;
		long temp;
		temp = Double.doubleToLongBits(powierzchnia);
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
		Spadochron other = (Spadochron) obj;
		if (dopuszczalnaMasaSkoczka != other.dopuszczalnaMasaSkoczka)
			return false;
		if (Double.doubleToLongBits(powierzchnia) != Double.doubleToLongBits(other.powierzchnia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Spadochron [powierzchnia=" + powierzchnia + ", dopuszczalnaMasaSkoczka=" + dopuszczalnaMasaSkoczka
				+ ", typ=" + typ + ", masa=" + masa + "]";
	}

}
