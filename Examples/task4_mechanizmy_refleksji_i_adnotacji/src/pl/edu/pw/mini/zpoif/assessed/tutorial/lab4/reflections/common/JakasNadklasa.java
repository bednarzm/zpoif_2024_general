package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.reflections.common;

public abstract class JakasNadklasa {
	
	protected String wiadomoscZNadklasy = "To jest pole nadklasy...";
	public String wiadomoscPublicznaZNadklasy = "To jest publiczne pole nadklasy";
	
	protected abstract void metodaDoNadpisania();
	
	protected int dziedziczonaMetodaZNadklasy() {
		return 33;
	}
	
}
