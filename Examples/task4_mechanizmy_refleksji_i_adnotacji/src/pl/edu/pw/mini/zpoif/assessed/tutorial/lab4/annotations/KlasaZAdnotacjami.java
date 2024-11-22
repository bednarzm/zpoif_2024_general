package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.annotations;

@AdnotacjaDlaKlasy
public class KlasaZAdnotacjami {
	/**
	 * Adnotacje s¹ elementami je¿yka Java, za pomoc¹ których mo¿na dodwaæ dodatkowe informacje do elementów
	 * klasy. Po co to robimy, przecie¿ mo¿na u¿ywaæ do tego celu komentarzy?
	 */
	
	/*
	 * Ta informacja nie zawiera nic nadzwyczajnego...
	 */
	public String informacja = "";
	
	/**
	 * Zwazmy ta to, i¿ komentarz jest informacj¹ dla ludzi, którzy czytaj¹ ten kod. 
	 * Natomiast adnotacjami zaszywa siê dodtkowa informacje dla programu. 
	 * Mo¿na uzyskaæ do nich dostêp za pomoc¹ refleksji i odpowiednio zareagowaæ. 
	 */
	/**
	 * To pole jest adnotowane adnotacj¹ "PoleTajne". 
	 * Adnotacja bêdzie widoczna od strony programistycznej i program bêdzie móg³ na ni¹ zareagowaæ.
	 */
	@PoleTajne
	public String informacjaTajna = "To jest tajna informacja. Zadanie z refleksji bêdzie zawiera³o uruchamianie metod na obiekcie.";
	
	/**
	 * Je¿eli kod programu wykryje adnotacjê na ty
	 */
	@Dopisek(trescDopisku = "Takie œrednie te zarobki... chyba, ¿e w dolarach.")
	private int zarobki = 2000; 
	
	@NieWywolujTejMetody
	public void nicNieznaczacaMetoda() {
		System.out.println("Metoda w zasadzie robi niewiele");
	}
	
}
