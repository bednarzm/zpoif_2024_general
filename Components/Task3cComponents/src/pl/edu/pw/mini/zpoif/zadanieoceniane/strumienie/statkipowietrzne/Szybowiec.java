package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne;

public class Szybowiec extends StatekPowietrzny {
	
	protected int predkoscDopuszczalna;
	protected Integer doskonalosc;

	public Szybowiec(String typ, int masa, int predkoscDopuszczalna, int doskonalosc) {
		super(typ, masa);
		this.predkoscDopuszczalna = predkoscDopuszczalna;
		this.doskonalosc = doskonalosc;
	}

	public Integer getDoskonalosc() {
		return doskonalosc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + doskonalosc;
		result = prime * result + predkoscDopuszczalna;
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
		Szybowiec other = (Szybowiec) obj;
		if (doskonalosc != other.doskonalosc)
			return false;
		if (predkoscDopuszczalna != other.predkoscDopuszczalna)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Szybowiec [predkoscDopuszczalna=" + predkoscDopuszczalna + ", doskonalosc=" + doskonalosc + ", typ="
				+ typ + ", masa=" + masa + "]";
	} 
	
	
}
