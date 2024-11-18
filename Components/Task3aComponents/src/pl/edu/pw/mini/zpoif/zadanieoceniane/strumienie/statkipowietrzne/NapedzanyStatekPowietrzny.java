package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne;

public abstract class NapedzanyStatekPowietrzny extends StatekPowietrzny {
	
	protected Integer zasieg;
	protected double predkoscWznoszenia;
	
	public NapedzanyStatekPowietrzny(String typ, int masa, int zasieg, double predkoscWznoszenia) {
		super(typ, masa);
		this.zasieg = zasieg;
		this.predkoscWznoszenia = predkoscWznoszenia;
	}

	public Integer getZasieg() {
		return zasieg;
	}

	public double getPredkoscWznoszenia() {
		return predkoscWznoszenia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(predkoscWznoszenia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + zasieg;
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
		NapedzanyStatekPowietrzny other = (NapedzanyStatekPowietrzny) obj;
		if (Double.doubleToLongBits(predkoscWznoszenia) != Double.doubleToLongBits(other.predkoscWznoszenia))
			return false;
		if (zasieg != other.zasieg)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NapedzanyStatekPowietrzny [zasieg=" + zasieg + ", predkoscWznoszenia=" + predkoscWznoszenia + "]";
	}
	
}
