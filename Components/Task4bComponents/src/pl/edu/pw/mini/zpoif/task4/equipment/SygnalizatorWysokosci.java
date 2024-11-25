package pl.edu.pw.mini.zpoif.task4.equipment;

public class SygnalizatorWysokosci {

	private static final int wysokoscProstej = 100;
	
	private int wysokoscOtwarcia;
	private int wysokoscWejscia;

	public SygnalizatorWysokosci() {
		wysokoscOtwarcia = 1200;
		wysokoscWejscia = 500;
	}

	public SygnalizatorWysokosci(Integer wysokoscOtwarcia, Integer wysokoscWejscia) {
		this.wysokoscOtwarcia = wysokoscOtwarcia;
		this.wysokoscWejscia = wysokoscWejscia;
	}

	public Integer getWysokoscOtwarcia() {
		return wysokoscOtwarcia;
	}

	public Integer getWysokoscWejscia() {
		return wysokoscWejscia;
	}

	public void setWysokoscOtwarcia(int wysokoscOtwarcia) {
		this.wysokoscOtwarcia = wysokoscOtwarcia;
	}

	public void setWysokoscWejscia(int wysokoscWejscia) {
		this.wysokoscWejscia = wysokoscWejscia;
	}
	
}
