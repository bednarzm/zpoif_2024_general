package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne;

public class Samolot extends NapedzanyStatekPowietrzny {
	
	protected Double powierzchniaNosna;
	protected Integer pulap;
	
	public Samolot(String typ, int masa, int zasieg, double predkoscWznoszenia, double powierzchniaNosna,
			int pulap) {
		super(typ, masa, zasieg, predkoscWznoszenia);
		this.powierzchniaNosna = powierzchniaNosna;
		this.pulap = pulap;
	}

	public Double getPowierzchniaNosna() {
		return powierzchniaNosna;
	}

	public Integer getPulap() {
		return pulap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(powierzchniaNosna);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pulap;
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
		Samolot other = (Samolot) obj;
		if (Double.doubleToLongBits(powierzchniaNosna) != Double.doubleToLongBits(other.powierzchniaNosna))
			return false;
		if (pulap != other.pulap)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Samolot [powierzchniaNosna=" + powierzchniaNosna + ", pulap=" + pulap + ", zasieg=" + zasieg
				+ ", predkoscWznoszenia=" + predkoscWznoszenia + ", typ=" + typ + ", masa=" + masa + "]";
	}

}
