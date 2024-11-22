package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.analysis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

import pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.reflections.common.KlasaJakKlasa;
/**
 * Mechanizm reflekcji umo�liwia nam: 
 * 	- uzyskiwanie informacji o klasach, kt�re s� szablonami do tworzenia nowych obiekt�w 
 * 		(pola, metody, implementowane interfejsy - og�lnie zawarto��)
 *  - manipulacj� na klasach (np. zmiana modyfikator�w dost�pu)
 *  - manipulacj� na istniej�cych obiektach (zmiany warto�ci p�l, wywo�ywanie metod itp.).
 *  
 * Mechanizm ten jest pot�nym narz�dziem znacznie rozszerzaj�cym mo�liwo�ci j�zyka Java. 
 * Nale�y go jednak stosowa� z umiarem i w przypadkach, gdy problem jest trudno rozwi�zywalny b�dz wcale 
 * za pomoc� tradycyjnych metod. 
 *
 */
public class ReflectionClassAnalysis {
	
	public static void main(String args[]) {
		
		statycznaAnalizaKlas();
		statycznaAnalizaPolKlas();
		statycznaAnalizaMetod();
		statycznaAnalizaKonstruktorow();
		statycznaAnalizaInne();
		
	}
	
	private static void statycznaAnalizaKlas() {
		
		System.out.println("\nStatyczna analiza klas. 1. ");
		/*
		 * KLASY
		 */
		/*
		 * Niech dana b�dzie klasa, do kt�rej mamy referencj� zainicjalizowan� now� instancj� obiektu.
		 */
		KlasaJakKlasa klasaJakKlasa = new KlasaJakKlasa();
		
		/*
		 * Wiemy czym jest instancja danej klasy (jej obiekt utworzony operatorem "new"). 
		 * Czym w takim razie jest sama KLASA? Ta definicja obiektu, na podstawie kt�rej jest on tworzony. 
		 * S� tam przecie� pola, metody, modyfikatory i inne elementy. Jest to wi�c taka matryca, na podstawie kt�rej 
		 * Maszyna Wirtualna mo�e utworzy� obiekt. 
		 * Mo�na sobie zatem zada� pytanie: czy mo�na si� odnie�� do klasy samej w sobie? Ot� mo�na, poniewa� opis danej klasy 
		 * r�wnie� jest obiektem do kt�rego mamy dost�p. 
		 */
		
		/*
		 * Klasa Class, jest niczym innym jak odno�nikiem/referencj� do WYBRANEJ klasy. 
		 * Jest typ generyczny, wi�c wypada "pilnowa� typu" (za pomoc� sufiksu generycznego <KlasaJakKlasa>).
		 * KlasaJakKlasa.class jest to odno�nik do obiektu, kt�ry dan� klas� opisuje. 
		 */
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		
		/*
		 * Mo�na te� odwo�ywa� si� i tak jak poni�ej, aczkolwiek w drugim przypadku kompilator wystosuje ostrze�enie, 
		 * b�d�ce zach�t� do poszanowania generycznej natury tej klasy (Class).
		 */
		 Class<?> opcja1 = KlasaJakKlasa.class;
		 Class opcja2 = KlasaJakKlasa.class;
		 
		/*
		 * Je�eli napiszemy referencjaNaKonkretnyObiektKlasy. oraz naci�niemy ctrl+space, 
		 * to w podpowiedziach pojawi si� masa metod pozwalaj�cych na zbieranie informacji o klasie 
		 * oraz na manipulacje na danym obiekcie. 
		 */
		
		 System.out.println("\nStatyczna analiza klas. 2. Nazwy klas. ");
		 /*
		  * Mo�emy usyska� nazw� tej klasy:
		  */
		 String simpleName = referencjaNaKonkretnyObiektKlasy.getSimpleName();
		 System.out.println("Class simple name: " + simpleName);
		 
		 String name = referencjaNaKonkretnyObiektKlasy.getName();
		 System.out.println("Class name: " + name);
		 
		 /*
		  * Nazwa prezentuj�ca dan� klas� w formacie importowym (po s�owie kluczowym import)
		  */
		 String canonicalName = referencjaNaKonkretnyObiektKlasy.getCanonicalName();
		 System.out.println("Class canonical name: " + canonicalName);
		 
		 /*
		  * Mo�na sprawdzi� czy klasa jest interfejsem. Opr�cz tego jest sporo ciekawych metod 
		  * o intuicyjnych nazwach rozpoczynaj�cych si� na "is...", kt�re mog� zwr�ci� wiele ciekawych 
		  * informacji.
		  */
		 Boolean inter = referencjaNaKonkretnyObiektKlasy.isInterface();
		 
		 System.out.println("\nStatyczna analiza klas. 3. Nazwy nadklasy. ");
		 /*
		  * Jest te� mo�liwo�� zbadania natury nadklasy, poprzez odwo�anie si� do niej. 
		  */
		 Class<?> superClass = referencjaNaKonkretnyObiektKlasy.getSuperclass();
		 System.out.println("Nazwa nadklasy: " + superClass.getSimpleName());
		 
		 System.out.println("\nStatyczna analiza klas. 4. Nazwy interfejs�w. ");
		 /*
		  * Mo�na r�wnie� wydedukowa� jakie interfejsy klasa implementuje
		  */
		 Class<?> interfaces[] = referencjaNaKonkretnyObiektKlasy.getInterfaces();
		 for(Class implementedInterface : interfaces) {
			 System.out.println("Interface: " + implementedInterface.getName());
		 }
		 
	}
	
	/**
	 * Metoda zawiera statyczn� analiz� zawarto�ci klasy (klasy jako szablonu dla obiekt�w).
	 * Istnieje mo�liwo�� dostepu do listy p�l w klasie. 
	 */
	private static void statycznaAnalizaPolKlas() {
		
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		
		 /* 
		  * Nie wymieni� tutaj wszystkiego. Sami mo�emy "po kropce" (referencjaNaKonkretnyObiektKlasy.) nacisn�� ctrl + space
		  *  i popatrze� jakie metody mamy do dyspozycji. 
		 */
		 System.out.println("\nStatyczna analiza p�l klas. 1. ");
		 System.out.println("Declared classes: ");
		 Class<?> declaredClasses[] = referencjaNaKonkretnyObiektKlasy.getDeclaredClasses();
		 for(Class clazz : declaredClasses) {
			 System.out.print(" >>> " + clazz.getName());
		 }
		 
		 
		 System.out.println("\nStatyczna analiza p�l klas. 2. ");
		 /*
		  * Poni�ej mamy mo�liwo�� uzyskania dost�pu do danych zwi�zanych z deklaracj� p�l
		  * w klasie.
		  */
		try {
			/*
			 * getField zwraca name referencj� na pole w klasie, je�eli jest ono publiczne.
			 */
			Field field = referencjaNaKonkretnyObiektKlasy.getField("wiadomoscPublicznaZNadklasy");
			Field field2 = referencjaNaKonkretnyObiektKlasy.getField("jakiesInnePole");
			
			System.out.println("Pole (getField): " + field.getName());
			System.out.println("Pole (getField): " + field2.getName() );
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nStatyczna analiza p�l klas. 3. ");
		/*
		 * Je�eli metody getField u�yjemy do niepublicznych p�l, sko�czy si� to wyj�tkiem...
		 */
		try {
			/*
			 * Pole poleInt jest prywatne.
			 */
			Field field = referencjaNaKonkretnyObiektKlasy.getField("poleInt");
			
			System.out.println("Pole (getField): " + field.getName());
		} catch (NoSuchFieldException | SecurityException e) {
			System.out.print("Wyj�tek!!! \n Pole poleInt jest prywatne. ");
		}
		
		System.out.println("\nStatyczna analiza p�l klas. 4. ");
		/*
		 * Je�eli zatem chcemy mie� dost�p do wi�kszej liczby p�l, mo�emy pos�u�y� si� 
		 * metod� getDeclaredFields.
		 */
		try {
			Field declaredField = referencjaNaKonkretnyObiektKlasy.getDeclaredField("poleInt");
			System.out.println("Declared field: " + declaredField.getName());
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nStatyczna analiza p�l klas. 5. ");
		/*
		 * Nie mo�emy natomiast uzyska� dost�pu do niepublicznych metod z nadklas.
		 * Pr�ba taka sko�czy si� wyrzuceniem wyj�tku.
		 */
		try {
			Field declaredFieldFromSuperClass1 = referencjaNaKonkretnyObiektKlasy.getDeclaredField("wiadomoscZNadklasy");
			Field declaredFieldFromSuperClass2 = referencjaNaKonkretnyObiektKlasy.getDeclaredField("wiadomoscPublicznaZNadklasy");
		} catch (NoSuchFieldException | SecurityException e) {
			System.out.println("Wyj�tek!!!. Nie mo�na uzyska� dost�pu do p�l nadklasy.");
		}
		
		System.out.println("\nStatyczna analiza p�l klas. 6. ");
		/*
		 * Je�eli chcemy si� odnie�� do p�l z nadklasy, to musimy po prostu pracowa� na obiekcie opisuj�cym
		 * nadklas�. 
		 */
		try {
			/*
			 * Ka�da klasa jest w stanie zwr�ci� nam referencj� do obiektu swojej nadklasy (z wyj�tkiem klasy Object). 
			 */
			Class<?> referencjaNaObiektNadklasy = referencjaNaKonkretnyObiektKlasy.getSuperclass();
			Field declaredFieldFromSuperClass1 = referencjaNaObiektNadklasy.getDeclaredField("wiadomoscZNadklasy");
			Field declaredFieldFromSuperClass2 = referencjaNaObiektNadklasy.getDeclaredField("wiadomoscPublicznaZNadklasy");
			System.out.println("Pola nadklasy: " + declaredFieldFromSuperClass1.getName() + " " + declaredFieldFromSuperClass2.getName());
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nStatyczna analiza p�l klas. 7. ");
		
		/*
		 * W prosty spos�b mo�na sprawdzi� modyfikatory klas.
		 */
		try {
			Field privateField = referencjaNaKonkretnyObiektKlasy.getDeclaredField("poleLong");
			int modifiers = privateField.getModifiers();
			/*
			 * Kombinacja w�asno�ci danego pola jest zakodowana w pewnej liczbie. 
			 * Odkodowanie za pomoc� odpowiednich masek bitowych wykonuje klasa Modifier.
			 */
			Modifier.isStatic(modifiers);
			Modifier.isPublic(modifiers);
			Modifier.isPrivate(modifiers);
			
			System.out.println("Modyfikatory wykryte na polu \"privateField\": "
					+ " static: " + Modifier.isStatic(modifiers) 
					+ " public: " + Modifier.isPublic(modifiers)
					+ " private: " + Modifier.isPrivate(modifiers));
			
			System.out.println("");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nStatyczna analiza p�l klas. 8. ");
		/*
		 * Mamy mo�liwo�� pobrania tablicy wszystkich p�l wyst�puj�cych w klasie: 
		 */
		Field[] fields = referencjaNaKonkretnyObiektKlasy.getDeclaredFields();
		System.out.println("Lista p�l w klasie: ");
		for(Field field : fields) {
			System.out.println("Pole: " + field.getName());
		}
		
		
	}
	
	/**
	 * Metoda zawiera statyczn� analiz� metod nale��cych do klasy.
	 * Za pomoc� mechanizmu reflekcji istnieje mo�liwo�� dost�pu do listy metod, 
	 * zadeklarowanych w klasie. 
	 */
	private static void statycznaAnalizaMetod() {
		/*****************************************************************************
		 * >>>>>>>>>>>>>>>>>>>>>>> METODY <<<<<<<<<<<<<<<<<<<<<<<<<<<<				 *
		 *****************************************************************************/
		System.out.println("\nStatyczna analiza metod klas. 1. ");
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		
		 /*
		  * W odr�nieniu od pobierania konkretnego pola, musimy jeszcze sprecyzowa� typ pobieranych parametr�w.
		  * W tym momencie pobieramy dane dotycz�ce metody "metodaStatyczna", kt�ra przyjmuje jeden argument typu String.
		  */
		Method myMethod;
		 
		try {
			myMethod = referencjaNaKonkretnyObiektKlasy.getDeclaredMethod("metodaStatyczna", String.class);
		
			/*
			 * Poni�ej kilka wybranych element�w informacji na temat tej metody.
			 */
			
			 /*
			  * Nazwa
			  */
			 String methodName = myMethod.getName();
			 
			 /*
			  * Zwracany typ
			  */
			 Type returnType = myMethod.getReturnType();
			 
			 /*
			  * Modyfikatory
			  */
			 String modifiers = Modifier.toString(myMethod.getModifiers());
			 System.out.println("Modyfikatory: " + modifiers);
			 System.out.println("Czy metoda jest: " + " static: " + Modifier.isStatic(myMethod.getModifiers())
			 										+ " public: " + Modifier.isPublic(myMethod.getModifiers())
			 										+ " private: " + Modifier.isPrivate(myMethod.getModifiers()));
			 
			 System.out.println("\nStatyczna analiza metod klas. 2. Modyfikatory.");
			 System.out.println("Metoda: " + methodName + " Zwracany typ: " + returnType.getTypeName() 
			 						+ " Modyfikatory: " + modifiers);
			 
			 System.out.println("\nStatyczna analiza metod klas. 3. Parametry.");
			 /*
			  * Parametry metody
			  */
			 Parameter[] parameters = myMethod.getParameters();
			 Class<?> parameterTypes[] = myMethod.getParameterTypes();
			 System.out.println("	Parametery: ");
			 for(Parameter parameter : parameters) {
				 System.out.print("			Parameter " + parameter.toString() + " Nazwa parametru: " + parameter.getName());
			 }
			 System.out.println();
			 
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		 
		 
		 //referencjaNaKonkretnyObiektKlasy.getMethod(canonicalName, parameterTypes);
		 
		 /*
		  * Mo�emy zczyta� sobie metody, kt�re w danej klasie s� zdefiniowane. 
		  * Pami�tajmy jednak o tym, i� zwracana jest tablica metod publicznych. 
		  */
		 Method[] methods = referencjaNaKonkretnyObiektKlasy.getMethods();
		 for (Method method : methods) {
			 System.out.println("Metoda: " + method.getName() + " liczba parametr�w: " + method.getParameterCount());
		 } 
		 
	}
	
	/**
	 * Poni�sza metoda pokazuje w jaki spos�b 
	 * Opr�cz wymienionych powy�ej sposob�w uzyskiwania informacji o klasie, 
	 * istnieje mo�liwo�� uzyskania dost�pu do listy konstruktor�w.
	 */
	public static void statycznaAnalizaKonstruktorow() {
		/*
		 * >>>>>>>>>>>>>>>>>>>>>>> KONSTRUKTORY <<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */
		
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		
		System.out.println("\nStatyczna analiza konstruktor�w. 1. Konstruktor.");
		/*
		 * Mo�emy dobra� si� do konstruktora danej klasy. Z tej racji �e konstruktor z danym zbiorem parametr�w 
		 * o konkretnych typach jest tylko jeden, mo�na go pobra� podaj�c typ jego parametr�w. 
		 * 
		 */
		try {
			/*
			 * Nale�y zauwa�y�, i� typy prymitywne te� dostarczaj� obiektu klasy (int.class).
			 */
			Constructor<KlasaJakKlasa> constructor = referencjaNaKonkretnyObiektKlasy.getConstructor(int.class);
			System.out.println(" Konstrukltor: " + constructor.getName());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			/*
			 * W przypadku pobrania konstruktora z wi�ksz� liczb� parametr�w, nale�y poda� ich typy jako lista parametr�w. 
			 */
			Constructor<KlasaJakKlasa> constructor = referencjaNaKonkretnyObiektKlasy.getConstructor(int.class, long.class);
			System.out.println(" Konstrukltor: " + constructor.getName());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		Constructor<?> constructors[] = referencjaNaKonkretnyObiektKlasy.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println("Constructor: " + constructor.getName());
		}
		
	}
	
	public static void statycznaAnalizaInne() {
		 /*
		  * Mo�na uzyska� dost�p do pakietu w kt�rym znajduje si� dana klasa.  
		  */
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		Package gotPackage = referencjaNaKonkretnyObiektKlasy.getPackage();
		System.out.println("Package: " + gotPackage.getName());
		
		/*
		 * Niech dana b�dzie klasa, do kt�rej mamy referencj� zainicjalizowan� now� instancj� obiektu.
		 */
		 KlasaJakKlasa klasaJakKlasa = new KlasaJakKlasa();
		 
		 /*
		  * Mo�na r�wnie� uzyska� dost�p do klasy z istniej�cej instancji.
		  */
		 Class<? extends KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy2 = klasaJakKlasa.getClass();
		 
	}
	
}
