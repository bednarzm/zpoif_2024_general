package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne;

public class SpadochronRatowniczy extends Spadochron {

	protected boolean siedzeniowy;
	protected int minimalnaWysokosc;

	public SpadochronRatowniczy(String typ, int masa, double powierzchnia, int dopuszczalnaMasaSkoczka,
			boolean siedzeniowy, int minimalnaWysokosc) {
		super(typ, masa, powierzchnia, dopuszczalnaMasaSkoczka);
		this.siedzeniowy = siedzeniowy;
		this.minimalnaWysokosc = minimalnaWysokosc;
	}

	public boolean isSiedzeniowy() {
		return siedzeniowy;
	}

	public int getMinimalnaWysokosc() {
		return minimalnaWysokosc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + minimalnaWysokosc;
		result = prime * result + (siedzeniowy ? 1231 : 1237);
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
		SpadochronRatowniczy other = (SpadochronRatowniczy) obj;
		if (minimalnaWysokosc != other.minimalnaWysokosc)
			return false;
		if (siedzeniowy != other.siedzeniowy)
			return false;
		return true;
	}
	
}
