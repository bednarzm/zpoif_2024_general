package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.reflections.common;

public class KlasaJakKlasa extends JakasNadklasa implements JedenInterfejs, DrugiInterfejs{
	
	public static final String STATYCZNE_POLE_FINALNE = "Hello final!";
	
	private int poleInt = 89;
	private long poleLong = 256000000l;
	public String jakiesInnePole = "Jakis ci¹g znaków";
	private JeszczeJednaKlasa jeszczeJednaKlasa;

	public KlasaJakKlasa() {
		
	}

	public KlasaJakKlasa(int poleInt) {
		super();
		this.poleInt = poleInt;
	}

	public KlasaJakKlasa(Integer poleInt) {
		super();
		this.poleInt = poleInt;
	}
	
	public KlasaJakKlasa(int poleInt, long poleLong) {
		super();
		this.poleInt = poleInt;
		this.poleLong = poleLong;
	}

	public KlasaJakKlasa(int poleInt, String jakiesInnePole, JeszczeJednaKlasa jeszczeJednaKlasa) {
		super();
		this.poleInt = poleInt;
		this.jakiesInnePole = jakiesInnePole;
		this.jeszczeJednaKlasa = jeszczeJednaKlasa;
	}

	private static void metodaStatyczna(String nazwa) {
		System.out.println("To ja, metoda statyczna! Nazywam siê: " + nazwa);
	}
	
	public void normalnaMetoda(int a, int b, String pozdrowienie) {
		System.out.println(pozdrowienie + " Suma parametrów: " + (a + b));
	}
	
	private int prywatnaMetodaKtoraCosZwraca(Integer integer) {
		return 22 + integer;
	}

	@Override
	protected void metodaDoNadpisania() {
		System.out.println("Metoda nadpisuje metodê z nadklasy...");
	}
	
	public void metodaPubliczna() {
		System.out.println("Jestem metoda publiczna...");
	}
	
}
