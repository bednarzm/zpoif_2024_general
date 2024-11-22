package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.dynamicoperations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.reflections.common.KlasaJakKlasa;

/**
 * Niniejszy zestaw przyk�ad�w pokazuje w jaki spos�b (u�ywaj�c metod refleksyjnych)
 * mo�na instancjonowa� obiekty, wywo�ywa� metody, otrzymywa� warto�ci p�l i zmienia� ich modyfikatory.
 *
 */
public class ReflectionClassManipulations {
	
	public static void main(String[] args) {
		
		instancjonowanie();
		dostepDoPol();
		wywolywanieMetod();
		refleksjeNadRefleksjami();
		
	}
	
	/**
	 * Instancjonowanie.
	 */
	public static void instancjonowanie() {
		
		/*
		 * Za��my, �e w naszym kodzie dysponujemy pe�n� nazw� klasy, kt�r� chcieliby�my utworzy�. 
		 * Niech b�dzie to klasa: KlasaJakKlasa
		 */
		 String pelnaNazwaKlasy = "pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.reflections.common.KlasaJakKlasa";
		 /*
		  * Mo�emy posiadaj�c t� informacj� utworzy� obiekt (instancj� tej klasy), tak jak robili�my to za pomoc� 
		  * operatora "new"
		  */
		 try {
			Class<?> odnosnikDoObiektuOpisujacegoKlase = Class.forName(pelnaNazwaKlasy);
			/*
			 * O ile podana nazwa klasy znajduje si� w zasi�gu Class Loadera, otrzymujemy obiekt typu Class<?>,
             * kt�ry reprezentuje klas�: KlasaJakKlasa
			 */
			
			try {
				//Kiedys robilo sie tak ale sprawialo to problemy w sprawie poszukiwania konstruktora. 
				//Object object = odnosnikDoObiektuOpisujacegoKlase.newInstance();
				
				//Tutaj jest lepsza metoda tworzenia instancji opierajaca sie na konkretnym konstruktorze.
				Object object = odnosnikDoObiektuOpisujacegoKlase.getConstructor(null).newInstance();
				
				/*
				 * Otrzymany obiekt jest obiektem klasy: KlasaJakKlasa. Mo�na to sprawdzi�. 
				 */
				System.out.println(" Czy obiekt jest instancj� klasy KlasaJakKlasa? " + (object instanceof KlasaJakKlasa));
				
				/*
				 * Mo�na podda� go castingowi:
				 */
				KlasaJakKlasa utworzonyPrzezRefleksje = (KlasaJakKlasa)object;
				utworzonyPrzezRefleksje.metodaPubliczna();
				
				
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			
			/*
			 * W powy�szym przypadku instancjonowanie si� powiod�o, poniewa� klasa mia�a konstruktor domy�lny (bezparametrowy).
			 * Nietrudno si� domy�li�, co si� stanie, gdy w ten sam spos�b b�dziemy pr�bowa� instancjonowa� klas�, kt�ra takowego 
			 * konstruktora nie posiada. Stw�rzmy sobie tymczasow� klas�, doceniaj�c zarazem mo�liwo�� tworzenia klas lokalnych.
			 */
			class KlasaBezKonstruktoraBezparametrowego{
				
				private int a;
				private String b;
				
				KlasaBezKonstruktoraBezparametrowego(int a){}

				public KlasaBezKonstruktoraBezparametrowego(int a, String b) {
					super();
					this.a = a;
					this.b = b;
				}

			}
			
			/*
			 * Spr�bujmy zainstancjonowa� sobie klas� w ramach refleksji. 
			 * Przy okazji zauwa�my jak wygl�da pe�na nazwa klasy lokalnej.
			 */
			Class<?> referencjaNaKlase = Class.forName("pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.dynamicoperations.ReflectionClassManipulations$1KlasaBezKonstruktoraBezparametrowego");
			
			try {
				Object object = referencjaNaKlase.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				/*
				 * W przypadku uruchomienia powy�szego bloku wyrzucony zostanie wyj�tek. 
				 * Klasa 
				 */
				System.out.println("Wyj�tek!!! - klasa lokalna nie posiada konstruktora bezparametrowego!");
			}
			
			/*
			 * Utw�rzmy zatem obiekt na podstawie konstruktora dwuparametrowego klasy lokalnej. 
			 */
			try {
				Constructor constructor = referencjaNaKlase.getConstructor(int.class, String.class);
				/*
				 * Teraz instancjonujemy nasz obiekt wywo�uj�c konstruktor dwuparametrowy.
				 */
				try {
					Object object = constructor.newInstance(new Object[] {10, "Hello!"});
					System.out.println("Obiekt zosta� stworzony za pomoc� konstruktora dwuparametrowego: " + object);
					System.out.println("Czy jest to obiekt klasy KlasaBezKonstruktoraBezparametrowego? " + (object instanceof KlasaBezKonstruktoraBezparametrowego));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			
			/*
			 * Mo�emy sobie wylistowa� konstruktory.
			 */
			Constructor constructors[] = referencjaNaKlase.getConstructors();
			for(Constructor constructor : constructors) {
				System.out.println("Konstruktor: " + constructor.getName() + " Liczba parametr�w: " + constructor.getParameterCount());
				/*
				 * Pami�tamy constructor. i ctrl + space. B�dzie tam (podobnie jak w przypadku metod) 
				 */
				constructor.getParameterTypes();//itd.
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
	}
	
	/**
	 * Dost�p do p�l istniej�cych obiekt�w (instancji klas)
	 */
	public static void dostepDoPol() {
		String pelnaNazwaKlasy = "pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.reflections.common.KlasaJakKlasa";
		/*
		 * Instancjonujemy. 
		 * P.S. Nazwa class jest zastrze�ona, wi�c czasmi u�ywa si� nazwy clazz. Jest to modne. 
		 * Je�li kto� chce by� na czasie, to mo�e u�ywa� takiego nazewnictwa. 
		 */
		try {
			Class<?> clazz = Class.forName(pelnaNazwaKlasy);
			try {
				Object object = clazz.newInstance();
				/*
				 * Klasa KlasaJakKlasa ma pole jakiesInnePole. Uzyskajmy jego warto��.
				 */
				try {
					Field field = clazz.getField("jakiesInnePole");
					/*
					 * W jaki spos�b mo�na uzyska� warto�� tego pola w konkretnym obiekcie?
					 * Wywo�ujemy metod� "get" na obiekcie opisuj�cym pole, podaj�c jako argument 
					 * konkretny obiekt 
					 */
					Object fieldValue = field.get(object);
					System.out.println("Warto�� pola: " + fieldValue);
					
					/*
					 * Je�eli znamy klas� warto�ci danego pola mo�emy pokusi� si� o jego casting.
					 * W tym przeypadku wiemy, �e jest too String. 
					 */
					String fieldValueAsString = (String)field.get(object);
					System.out.println("Warto�� pola jako String: " + fieldValueAsString);
					
				} catch (NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
				
				/*
				 * Co si� stanie, je�eli b�dziemy chcieli uzyska� dost�p do pola niedost�pnego (np. prywatnego)
				 */
				try {
					Field intField = clazz.getDeclaredField("poleInt");
					try {
						intField.get(object);
					} catch(IllegalAccessException illegalAccessException) {
						/*
						 * Ten wyj�tek b�dzie wyrzucony.
						 */
						System.out.println("Wyj�tek! Nie mo�na uzyska� dost�pu do pola prywatnego!");
					}
				} catch (NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
				
				/*
				 * 
				 * Co robi�? Zmieni� modyfikator. 
				 * W Javie przewidziano tak� ewentualno�� i wprowadzono mo�liwo�� zmiany dost�pno�ci pola lub metody.
				 * Aby uzyska� dost�p do tego pola mo�na na chwil� (lub do ko�ca dzia�ania programu) uczyni� go dost�pnym. 
				 * 
				 */
				try {
					/*
					 * Czemu getDeclaredField, a nie po prostu getField? Bo getField odnosi si� tylko do metod publicznych.
					 */
					try {
						Field intField = clazz.getDeclaredField("poleInt");
						intField.setAccessible(true);
						Object gotObject = intField.get(object);
						/*
						 * Tutaj wyj�tek nie b�dzie rzucony, bo dzi�ki metodzie setAccessible pole sta�o si� dost�pne. 
						 * To samo mo�na zrobi� i z metodami.
						 */
						System.out.println("Warto�� pola prywatnego uzyskanego za pomoc� modyfikaji dost�pu do niego: " + gotObject);
					
						/*
						 * Je�eli pole zawiera typ liczbowy, to mo�emy pos�u�y� si� metodami klasy Field.
						 */
						int value = intField.getInt(object);
						System.out.println("Warto�� pola uzyskana za pomoc� getInt: " + value);
					} catch(IllegalAccessException illegalAccessException) {
						illegalAccessException.printStackTrace();
					}
					
				} catch (NoSuchFieldException | SecurityException e) {
					System.out.println("AWyj�tek! Nie mo�na uzyska� dost�pu do pola prywatnego!");
				}
				
				Field fields[] = clazz.getDeclaredFields();
				for(Field field : fields) {
					//Mo�na co� zrobi� z metodami udost�pnianymi przez klas� Field
					field.setAccessible(true);
					System.out.println("Pole: " + field.get(object));
				}
				
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Wywo�ywanie metod obiekt�w (instancji klas)
	 */
	public static void wywolywanieMetod() {
		String pelnaNazwaKlasy = "pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.reflections.common.KlasaJakKlasa";
		/*
		 * Instancjonujemy. 
		 * P.S. Nazwa class jest zastrze�ona, wi�c czasmi u�ywa si� nazwy clazz. Jest to modne. 
		 * Je�li kto� chce by� na czasie, to mo�e u�ywa� takiego nazewnictwa. 
		 */

		Class<?> clazz;
		try {
			clazz = Class.forName(pelnaNazwaKlasy);
			try {
				Object object = clazz.newInstance();
				/*
				 * Za��my, �e chcemy wywo�a� metod� (z jakimi� parametrami) znaj�c jej nazw� i typy 
				 * przyjmowanych argument�w. Niech b�dzie to "normalnaMetoda" przyjmuj�ca dwa argumenty (int, int i String)
				 */
				try {
					Method normalnaMetodaMethod = clazz.getMethod("normalnaMetoda", int.class, int.class, String.class);
					/*
					 * Wywo�ujemy metod� na konkretnej instancji obiektu (object), podaj�c jednocze�nie list� argument�w.
					 */
					try {
						normalnaMetodaMethod.invoke(object, new Integer(1), new Integer(2), "Hej!");
						Object o[] = {new Integer(1), new Integer(2), "Hej!"};
						/*
						 * Mo�na te� i tak...
						 */
						normalnaMetodaMethod.invoke(object, o);
						
					} catch (IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				
				/*
				 * Za��my, ze chcemy wywo�a� metod�, kt�ra jest prywatna. 
				 */
				
				try {
					Method normalnaMetodaMethod = clazz.getDeclaredMethod("prywatnaMetodaKtoraCosZwraca", Integer.class);
					
					try {
						normalnaMetodaMethod.invoke(object, 133);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						System.out.println("Wyj�tek! Nast�pi�a pr�ba dost�pu do metody prywatnej!");
					}
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				
				/*
				 * Je�eli b�dziemy chcieli wywo�a� metod�, kt�ra nie jest dost�pna (np. prywatna),
				 * to podobnie jak w przypadku p�l mo�emy zmieni� dostepno�� danej metody.
				 */
				try {
					Method normalnaMetodaMethod = clazz.getDeclaredMethod("prywatnaMetodaKtoraCosZwraca", Integer.class);
					try {
						normalnaMetodaMethod.setAccessible(true);
						normalnaMetodaMethod.invoke(object, 133);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						System.out.println("Wyj�tek! Nast�pi�a pr�ba dost�pu do metody prywatnej!");
					}
				} catch (NoSuchMethodException | SecurityException e) {
					System.out.println("Wyj�tek! Nast�pi�a pr�ba dost�pu do metody prywatnej!");
				}
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Podsumowanie
	 */
	private static void refleksjeNadRefleksjami(){
		/*
		 Na my�l przychodzi pytanie. Po co to wszystko??? 
		 Po co tak utrudnia� sobie �ycie, jak mo�na u�y� operatora "new", a na istniej�cym obiekcie poprostu wywo�a� metod� 
		 tak jak to robili�my do tej pory. 
		 */
		KlasaJakKlasa klasaJakKlasa = new KlasaJakKlasa();
		String wartoscPola = klasaJakKlasa.jakiesInnePole;
		klasaJakKlasa.metodaPubliczna();
		
		/*
		 * Wyobrazmy sobie sytuacj�, �e mamy dostarczy� algorytm, kt�ry wywo�uje metody z biblioteki, 
		 * kt�ra jeszcze nie zosta�a stworzona. Kod wywo�uj�cy metod� nie b�dzie p�zniej rozwijany, 
		 * a jedyn� informacj� do tego b�dzie nazwa tej metody.
		 */
		
		/*
		 * Za��my, �e chcemy dostarczy� oprogramowanie testuj�ce jaki� zestaw klas. Kto� na drugim ko�cu �wiata 
		 * napisa� program w Javie i my jako osoby neutralne chcemy sprawdzi�, czy to dzia�a. 
		 * Klasy testowane maj� sporo niedost�pnych p�l (np. prywatnych), 
		 * od kt�rych zale�y ich dzia�anie. Wyobrazmy sobie, i� chcemy sprawdzi� co si� stanie je�li te pola 
		 * b�d� mia�y takie a takie warto�ci. Dodatkowo NIE MO�EMY zmienia� kodu klas testowanych nawet na chwil�. 
		 * Bez refleksji tego nie zrobimy.
		 */
		
		/*
		 * Wyobrazmy sobie sytuacj�, w kt�rej nasz kod b�dzie chcia� utworzy� instancj� obiektu, kt�ry 
		 * b�dzie stworzony za rok. Jak mamy stworzy� instancj� obiektu dzi� za pomoc� operatora "new", 
		 * skoro on jeszcze nie istnieje. 
		 */
		
		/*
		 * I tak dalej i tak dalej...
		 */
		
		/*
		 * Pami�taj, mechanizmu refleksji u�ywamy wtedy, gdy danego problemu nie mo�na rozwi�za� w inny spos�b. 
		 * Nie nadu�ywamy tego mechanizmu, cho�by dlatego, �e w niekt�rych miejscach omija on naturaln� ochron�, 
		 * kt�r� zapewnie kompilator. Niekt�re problemy mog� nie by� wykryte automatycznie w czasie fazy kompilacji, 
		 * tylko ujrz� �wiat�o dzienne dopiero w fazie uruchomienia (a tego zawsze chcieliby�my unikn��). 
		 * Np. 
		 */
		
		KlasaJakKlasa naszaKlasa = new pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.reflections.common.KlasaJakKlasa();
		/*
		 * Podali�my tutaj pe�n� nazw� klasy razem z pakietem (mo�na tak zrobi�). Je�eli takie klasy nie b�dzie w zasi�gu
		 * kompilatora, to jeszcze przed uruchomieniem wska�e on nam b��d. Prosz� odkomentowa� i zobaczy�.
		 */
		
		//naszaKlasa = new pl.edu.pw.NIE.MA.TAKIEJ.KLASY.I.NIE.BEDZIE.common.KlasaJakKlasa();
		
		/*
		 * Je�eli odkomentujemy powy�sz� linijk�, to program nawet nie zostanie zbudowany, a co dopiero m�wi� o jego uruchomieniu.
		 */
		
		/*
		 * Natomiast w poni�szym przypadku, gdy klas� naszaKlasa KlasaJakKlasa instancjonujemy poprzez "tekstowe" podanie jej nazwy
		 * to w przypadku, gdy nazwa b�dzie b��dna (taka klasa nie b�dzie istnia�a), to problem wyjdzie dopiero po uruchomieniu. 
		 */
		
		try {
			Class<?> clazz = Class.forName("pl.edu.pw.NIE.MA.TAKIEJ.KLASY.I.NIE.BEDZIE.common.KlasaJakKlasa");
			
		} catch (ClassNotFoundException e) {
			/*
			 * Jak wida�, wyj�tek si� pojawi, wi�c b��d ujrzy �wiat�o dzienne mimo �e kompilator nie znalaz� b��du i dopu�ci� 
			 * kod do budowy i uruchomienia.
			 */
			System.out.println("Wyjatek!!! Nie ma takiej klasy!");
		}
		
		
	}
	
}
