package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.annotations;

@AdnotacjaDlaKlasy
public class KlasaZAdnotacjami {
	/**
	 * Adnotacje s� elementami je�yka Java, za pomoc� kt�rych mo�na dodwa� dodatkowe informacje do element�w
	 * klasy. Po co to robimy, przecie� mo�na u�ywa� do tego celu komentarzy?
	 */
	
	/*
	 * Ta informacja nie zawiera nic nadzwyczajnego...
	 */
	public String informacja = "";
	
	/**
	 * Zwazmy ta to, i� komentarz jest informacj� dla ludzi, kt�rzy czytaj� ten kod. 
	 * Natomiast adnotacjami zaszywa si� dodtkowa informacje dla programu. 
	 * Mo�na uzyska� do nich dost�p za pomoc� refleksji i odpowiednio zareagowa�. 
	 */
	/**
	 * To pole jest adnotowane adnotacj� "PoleTajne". 
	 * Adnotacja b�dzie widoczna od strony programistycznej i program b�dzie m�g� na ni� zareagowa�.
	 */
	@PoleTajne
	public String informacjaTajna = "To jest tajna informacja. Zadanie z refleksji b�dzie zawiera�o uruchamianie metod na obiekcie.";
	
	/**
	 * Je�eli kod programu wykryje adnotacj� na ty
	 */
	@Dopisek(trescDopisku = "Takie �rednie te zarobki... chyba, �e w dolarach.")
	private int zarobki = 2000; 
	
	@NieWywolujTejMetody
	public void nicNieznaczacaMetoda() {
		System.out.println("Metoda w zasadzie robi niewiele");
	}
	
}
