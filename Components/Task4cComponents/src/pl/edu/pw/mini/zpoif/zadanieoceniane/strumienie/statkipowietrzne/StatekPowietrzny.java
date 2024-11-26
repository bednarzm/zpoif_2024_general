package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne;

public abstract class StatekPowietrzny {
	
	protected String typ;
	protected Integer masa;
	
	public StatekPowietrzny(String typ, int masa) {
		this.typ = typ;
		this.masa = masa;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public Integer getMasa() {
		return masa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + masa;
		result = prime * result + ((typ == null) ? 0 : typ.hashCode());
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
		StatekPowietrzny other = (StatekPowietrzny) obj;
		if (masa != other.masa)
			return false;
		if (typ == null) {
			if (other.typ != null)
				return false;
		} else if (!typ.equals(other.typ))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StatekPowietrzny [typ=" + typ + ", masa=" + masa + "]";
	}
	
}
