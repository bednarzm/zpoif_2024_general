package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotations4Us {
	
	public static void main(String[] args) {
		showAnnotations();
	}

	private static void showAnnotations() {
		try {
			Class<?> clazz = Class.forName("pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.annotations.KlasaZAdnotacjami");
			
			Object instiantiatedObject = clazz.newInstance();
			
			/*
			 * Mo�emy wylistowa� sobie wszystkie adnotacje u�yte na danej klasie.
			 */
			Annotation classAnnotations[] = clazz.getAnnotations();
			for(Annotation annotation : classAnnotations) {
				System.out.println("Adnotacja: " + annotation.toString());
			}
			
			/*
			 * Uzyskajmy dost�p do pola "informacjaTajna"
			 */
			try {
				Field fieldInformacjaTajna = clazz.getField("informacjaTajna");
				/*
				 * Mo�emy wylistowa� sobie adnotacje dla tego pola.
				 */
				Annotation[] annotations = fieldInformacjaTajna.getAnnotations();
				for(Annotation annotation : annotations) {
					System.out.println("Adnotacja dla pola: " + annotation.toString());
				}
				
				/*
				 * Je�eli mamy podstawy oczekiwa�, �e dane pole b�dzie adnotowane, mo�emy to sprawdzi�.
				 */
				PoleTajne poleTajne = fieldInformacjaTajna.getAnnotation(PoleTajne.class);
				if(poleTajne != null) {
					/*
					 * Je�eli oka�e si�, �e badane pole posiada adnotacj�, to maj�c t� wiedz� mo�emy odpowiednio zareagowa�. 
					 * Tutaj np. nie b�dziemy wypisywa� warto�ci tego pola, bo kto� ustawi� tak� adnotacj�, wi�c nie b�dziemy go wypisywa�.
					 */
					System.out.println("Niestety to jest pole tajne, wi�c nie b�dziemy wypisywa� jego warto�ci.");
				} else {
					try {
						System.out.println("Pole tajne: " + fieldInformacjaTajna.getInt(instiantiatedObject));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				
				/*
				 * Za��my, �e chcemy wy�wietli� zawarto�� pola "zarobki". Plan mamy taki, i� je�eli 
				 * b�dzie tam adnotacja np. Dopisek, to zareagujemy na to wypisuj�c jego zawarto��.
				 */
				Field zarobkiField = clazz.getDeclaredField("zarobki");
				/*
				 * Pami�tamy, jest po pole prywatne, wi�c "w�amiemy si�" na chwil� do klasy.
				 */
				zarobkiField.setAccessible(true);
				int zarobki = zarobkiField.getInt(instiantiatedObject);
				Dopisek dopisek = zarobkiField.getAnnotation(Dopisek.class);
				if(dopisek != null) {
					System.out.println("Zarobki: " + zarobki + " Mamy te� dopiek: " + dopisek.trescDopisku());
				} else {
					System.out.println("Zarobki: " + zarobki + " B�dzie bez dopisku");
				}
				
				/*
				 * Niech informacj� stanowi�c� o tym, i� dana metoda nie mo�e by� wywo�ana, b�dzie istnieje adnotacji 
				 * NieWywolujTejMetody przy tej metodzie. 
				 */
				try {
					Method nicNieznaczacaMetoda = clazz.getMethod("nicNieznaczacaMetoda");
					NieWywolujTejMetody nieWywolujTejMetody = nicNieznaczacaMetoda.getAnnotation(NieWywolujTejMetody.class);
					if(nieWywolujTejMetody != null) {
						System.out.println("Sorry, z pewnych wzgl�d�w nie mog� wywo�a� tej metody i nie mog� powiedzie� dlaczego.");
					} else {
						System.out.println("Wywo�am metod�, bo nikt mi tego nie zabrania.");
						try {
							nicNieznaczacaMetoda.invoke(instiantiatedObject);//Metoda jest bezparametrowa, wi�c nie podaj� jej argument�w.
						} catch (IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
				
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
	}
	
}
