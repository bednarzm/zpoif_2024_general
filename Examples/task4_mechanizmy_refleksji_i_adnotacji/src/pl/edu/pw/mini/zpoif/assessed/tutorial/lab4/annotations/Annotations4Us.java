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
			 * Mo¿emy wylistowaæ sobie wszystkie adnotacje u¿yte na danej klasie.
			 */
			Annotation classAnnotations[] = clazz.getAnnotations();
			for(Annotation annotation : classAnnotations) {
				System.out.println("Adnotacja: " + annotation.toString());
			}
			
			/*
			 * Uzyskajmy dostêp do pola "informacjaTajna"
			 */
			try {
				Field fieldInformacjaTajna = clazz.getField("informacjaTajna");
				/*
				 * Mo¿emy wylistowaæ sobie adnotacje dla tego pola.
				 */
				Annotation[] annotations = fieldInformacjaTajna.getAnnotations();
				for(Annotation annotation : annotations) {
					System.out.println("Adnotacja dla pola: " + annotation.toString());
				}
				
				/*
				 * Je¿eli mamy podstawy oczekiwaæ, ¿e dane pole bêdzie adnotowane, mo¿emy to sprawdziæ.
				 */
				PoleTajne poleTajne = fieldInformacjaTajna.getAnnotation(PoleTajne.class);
				if(poleTajne != null) {
					/*
					 * Je¿eli oka¿e siê, ¿e badane pole posiada adnotacjê, to maj¹c t¹ wiedzê mo¿emy odpowiednio zareagowaæ. 
					 * Tutaj np. nie bêdziemy wypisywaæ wartoœci tego pola, bo ktoœ ustawi³ tak¹ adnotacjê, wiêc nie bêdziemy go wypisywaæ.
					 */
					System.out.println("Niestety to jest pole tajne, wiêc nie bêdziemy wypisywaæ jego wartoœci.");
				} else {
					try {
						System.out.println("Pole tajne: " + fieldInformacjaTajna.getInt(instiantiatedObject));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				
				/*
				 * Za³ó¿my, ¿e chcemy wyœwietliæ zawartoœæ pola "zarobki". Plan mamy taki, i¿ je¿eli 
				 * bêdzie tam adnotacja np. Dopisek, to zareagujemy na to wypisuj¹c jego zawartoœæ.
				 */
				Field zarobkiField = clazz.getDeclaredField("zarobki");
				/*
				 * Pamiêtamy, jest po pole prywatne, wiêc "w³amiemy siê" na chwilê do klasy.
				 */
				zarobkiField.setAccessible(true);
				int zarobki = zarobkiField.getInt(instiantiatedObject);
				Dopisek dopisek = zarobkiField.getAnnotation(Dopisek.class);
				if(dopisek != null) {
					System.out.println("Zarobki: " + zarobki + " Mamy te¿ dopiek: " + dopisek.trescDopisku());
				} else {
					System.out.println("Zarobki: " + zarobki + " Bêdzie bez dopisku");
				}
				
				/*
				 * Niech informacj¹ stanowi¹c¹ o tym, i¿ dana metoda nie mo¿e byæ wywo³ana, bêdzie istnieje adnotacji 
				 * NieWywolujTejMetody przy tej metodzie. 
				 */
				try {
					Method nicNieznaczacaMetoda = clazz.getMethod("nicNieznaczacaMetoda");
					NieWywolujTejMetody nieWywolujTejMetody = nicNieznaczacaMetoda.getAnnotation(NieWywolujTejMetody.class);
					if(nieWywolujTejMetody != null) {
						System.out.println("Sorry, z pewnych wzglêdów nie mogê wywo³aæ tej metody i nie mogê powiedzieæ dlaczego.");
					} else {
						System.out.println("Wywo³am metodê, bo nikt mi tego nie zabrania.");
						try {
							nicNieznaczacaMetoda.invoke(instiantiatedObject);//Metoda jest bezparametrowa, wiêc nie podajê jej argumentów.
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
