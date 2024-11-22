package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.analysis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

import pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.reflections.common.KlasaJakKlasa;
/**
 * Mechanizm reflekcji umo¿liwia nam: 
 * 	- uzyskiwanie informacji o klasach, które s¹ szablonami do tworzenia nowych obiektów 
 * 		(pola, metody, implementowane interfejsy - ogólnie zawartoœæ)
 *  - manipulacjê na klasach (np. zmiana modyfikatorów dostêpu)
 *  - manipulacjê na istniej¹cych obiektach (zmiany wartoœci pól, wywo³ywanie metod itp.).
 *  
 * Mechanizm ten jest potê¿nym narzêdziem znacznie rozszerzaj¹cym mo¿liwoœci jêzyka Java. 
 * Nale¿y go jednak stosowaæ z umiarem i w przypadkach, gdy problem jest trudno rozwi¹zywalny b¹dz wcale 
 * za pomoc¹ tradycyjnych metod. 
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
		 * Niech dana bêdzie klasa, do której mamy referencjê zainicjalizowan¹ now¹ instancj¹ obiektu.
		 */
		KlasaJakKlasa klasaJakKlasa = new KlasaJakKlasa();
		
		/*
		 * Wiemy czym jest instancja danej klasy (jej obiekt utworzony operatorem "new"). 
		 * Czym w takim razie jest sama KLASA? Ta definicja obiektu, na podstawie której jest on tworzony. 
		 * S¹ tam przecie¿ pola, metody, modyfikatory i inne elementy. Jest to wiêc taka matryca, na podstawie której 
		 * Maszyna Wirtualna mo¿e utworzyæ obiekt. 
		 * Mo¿na sobie zatem zadaæ pytanie: czy mo¿na siê odnieœæ do klasy samej w sobie? Otó¿ mo¿na, poniewa¿ opis danej klasy 
		 * równie¿ jest obiektem do którego mamy dostêp. 
		 */
		
		/*
		 * Klasa Class, jest niczym innym jak odnoœnikiem/referencj¹ do WYBRANEJ klasy. 
		 * Jest typ generyczny, wiêc wypada "pilnowaæ typu" (za pomoc¹ sufiksu generycznego <KlasaJakKlasa>).
		 * KlasaJakKlasa.class jest to odnoœnik do obiektu, który dan¹ klasê opisuje. 
		 */
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		
		/*
		 * Mo¿na te¿ odwo³ywaæ siê i tak jak poni¿ej, aczkolwiek w drugim przypadku kompilator wystosuje ostrze¿enie, 
		 * bêd¹ce zachêt¹ do poszanowania generycznej natury tej klasy (Class).
		 */
		 Class<?> opcja1 = KlasaJakKlasa.class;
		 Class opcja2 = KlasaJakKlasa.class;
		 
		/*
		 * Je¿eli napiszemy referencjaNaKonkretnyObiektKlasy. oraz naciœniemy ctrl+space, 
		 * to w podpowiedziach pojawi siê masa metod pozwalaj¹cych na zbieranie informacji o klasie 
		 * oraz na manipulacje na danym obiekcie. 
		 */
		
		 System.out.println("\nStatyczna analiza klas. 2. Nazwy klas. ");
		 /*
		  * Mo¿emy usyskaæ nazwê tej klasy:
		  */
		 String simpleName = referencjaNaKonkretnyObiektKlasy.getSimpleName();
		 System.out.println("Class simple name: " + simpleName);
		 
		 String name = referencjaNaKonkretnyObiektKlasy.getName();
		 System.out.println("Class name: " + name);
		 
		 /*
		  * Nazwa prezentuj¹ca dan¹ klasê w formacie importowym (po s³owie kluczowym import)
		  */
		 String canonicalName = referencjaNaKonkretnyObiektKlasy.getCanonicalName();
		 System.out.println("Class canonical name: " + canonicalName);
		 
		 /*
		  * Mo¿na sprawdziæ czy klasa jest interfejsem. Oprócz tego jest sporo ciekawych metod 
		  * o intuicyjnych nazwach rozpoczynaj¹cych siê na "is...", które mog¹ zwróciæ wiele ciekawych 
		  * informacji.
		  */
		 Boolean inter = referencjaNaKonkretnyObiektKlasy.isInterface();
		 
		 System.out.println("\nStatyczna analiza klas. 3. Nazwy nadklasy. ");
		 /*
		  * Jest te¿ mo¿liwoœæ zbadania natury nadklasy, poprzez odwo³anie siê do niej. 
		  */
		 Class<?> superClass = referencjaNaKonkretnyObiektKlasy.getSuperclass();
		 System.out.println("Nazwa nadklasy: " + superClass.getSimpleName());
		 
		 System.out.println("\nStatyczna analiza klas. 4. Nazwy interfejsów. ");
		 /*
		  * Mo¿na równie¿ wydedukowaæ jakie interfejsy klasa implementuje
		  */
		 Class<?> interfaces[] = referencjaNaKonkretnyObiektKlasy.getInterfaces();
		 for(Class implementedInterface : interfaces) {
			 System.out.println("Interface: " + implementedInterface.getName());
		 }
		 
	}
	
	/**
	 * Metoda zawiera statyczn¹ analizê zawartoœci klasy (klasy jako szablonu dla obiektów).
	 * Istnieje mo¿liwoœæ dostepu do listy pól w klasie. 
	 */
	private static void statycznaAnalizaPolKlas() {
		
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		
		 /* 
		  * Nie wymieniê tutaj wszystkiego. Sami mo¿emy "po kropce" (referencjaNaKonkretnyObiektKlasy.) nacisn¹æ ctrl + space
		  *  i popatrzeæ jakie metody mamy do dyspozycji. 
		 */
		 System.out.println("\nStatyczna analiza pól klas. 1. ");
		 System.out.println("Declared classes: ");
		 Class<?> declaredClasses[] = referencjaNaKonkretnyObiektKlasy.getDeclaredClasses();
		 for(Class clazz : declaredClasses) {
			 System.out.print(" >>> " + clazz.getName());
		 }
		 
		 
		 System.out.println("\nStatyczna analiza pól klas. 2. ");
		 /*
		  * Poni¿ej mamy mo¿liwoœæ uzyskania dostêpu do danych zwi¹zanych z deklaracj¹ pól
		  * w klasie.
		  */
		try {
			/*
			 * getField zwraca name referencjê na pole w klasie, je¿eli jest ono publiczne.
			 */
			Field field = referencjaNaKonkretnyObiektKlasy.getField("wiadomoscPublicznaZNadklasy");
			Field field2 = referencjaNaKonkretnyObiektKlasy.getField("jakiesInnePole");
			
			System.out.println("Pole (getField): " + field.getName());
			System.out.println("Pole (getField): " + field2.getName() );
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nStatyczna analiza pól klas. 3. ");
		/*
		 * Je¿eli metody getField u¿yjemy do niepublicznych pól, skoñczy siê to wyj¹tkiem...
		 */
		try {
			/*
			 * Pole poleInt jest prywatne.
			 */
			Field field = referencjaNaKonkretnyObiektKlasy.getField("poleInt");
			
			System.out.println("Pole (getField): " + field.getName());
		} catch (NoSuchFieldException | SecurityException e) {
			System.out.print("Wyj¹tek!!! \n Pole poleInt jest prywatne. ");
		}
		
		System.out.println("\nStatyczna analiza pól klas. 4. ");
		/*
		 * Je¿eli zatem chcemy mieæ dostêp do wiêkszej liczby pól, mo¿emy pos³u¿yæ siê 
		 * metod¹ getDeclaredFields.
		 */
		try {
			Field declaredField = referencjaNaKonkretnyObiektKlasy.getDeclaredField("poleInt");
			System.out.println("Declared field: " + declaredField.getName());
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nStatyczna analiza pól klas. 5. ");
		/*
		 * Nie mo¿emy natomiast uzyskaæ dostêpu do niepublicznych metod z nadklas.
		 * Próba taka skoñczy siê wyrzuceniem wyj¹tku.
		 */
		try {
			Field declaredFieldFromSuperClass1 = referencjaNaKonkretnyObiektKlasy.getDeclaredField("wiadomoscZNadklasy");
			Field declaredFieldFromSuperClass2 = referencjaNaKonkretnyObiektKlasy.getDeclaredField("wiadomoscPublicznaZNadklasy");
		} catch (NoSuchFieldException | SecurityException e) {
			System.out.println("Wyj¹tek!!!. Nie mo¿na uzyskaæ dostêpu do pól nadklasy.");
		}
		
		System.out.println("\nStatyczna analiza pól klas. 6. ");
		/*
		 * Je¿eli chcemy siê odnieœæ do pól z nadklasy, to musimy po prostu pracowaæ na obiekcie opisuj¹cym
		 * nadklasê. 
		 */
		try {
			/*
			 * Ka¿da klasa jest w stanie zwróciæ nam referencjê do obiektu swojej nadklasy (z wyj¹tkiem klasy Object). 
			 */
			Class<?> referencjaNaObiektNadklasy = referencjaNaKonkretnyObiektKlasy.getSuperclass();
			Field declaredFieldFromSuperClass1 = referencjaNaObiektNadklasy.getDeclaredField("wiadomoscZNadklasy");
			Field declaredFieldFromSuperClass2 = referencjaNaObiektNadklasy.getDeclaredField("wiadomoscPublicznaZNadklasy");
			System.out.println("Pola nadklasy: " + declaredFieldFromSuperClass1.getName() + " " + declaredFieldFromSuperClass2.getName());
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nStatyczna analiza pól klas. 7. ");
		
		/*
		 * W prosty sposób mo¿na sprawdziæ modyfikatory klas.
		 */
		try {
			Field privateField = referencjaNaKonkretnyObiektKlasy.getDeclaredField("poleLong");
			int modifiers = privateField.getModifiers();
			/*
			 * Kombinacja w³asnoœci danego pola jest zakodowana w pewnej liczbie. 
			 * Odkodowanie za pomoc¹ odpowiednich masek bitowych wykonuje klasa Modifier.
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
		
		System.out.println("\nStatyczna analiza pól klas. 8. ");
		/*
		 * Mamy mo¿liwoœæ pobrania tablicy wszystkich pól wystêpuj¹cych w klasie: 
		 */
		Field[] fields = referencjaNaKonkretnyObiektKlasy.getDeclaredFields();
		System.out.println("Lista pól w klasie: ");
		for(Field field : fields) {
			System.out.println("Pole: " + field.getName());
		}
		
		
	}
	
	/**
	 * Metoda zawiera statyczn¹ analizê metod nale¿¹cych do klasy.
	 * Za pomoc¹ mechanizmu reflekcji istnieje mo¿liwoœæ dostêpu do listy metod, 
	 * zadeklarowanych w klasie. 
	 */
	private static void statycznaAnalizaMetod() {
		/*****************************************************************************
		 * >>>>>>>>>>>>>>>>>>>>>>> METODY <<<<<<<<<<<<<<<<<<<<<<<<<<<<				 *
		 *****************************************************************************/
		System.out.println("\nStatyczna analiza metod klas. 1. ");
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		
		 /*
		  * W odró¿nieniu od pobierania konkretnego pola, musimy jeszcze sprecyzowaæ typ pobieranych parametrów.
		  * W tym momencie pobieramy dane dotycz¹ce metody "metodaStatyczna", która przyjmuje jeden argument typu String.
		  */
		Method myMethod;
		 
		try {
			myMethod = referencjaNaKonkretnyObiektKlasy.getDeclaredMethod("metodaStatyczna", String.class);
		
			/*
			 * Poni¿ej kilka wybranych elementów informacji na temat tej metody.
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
		  * Mo¿emy zczytaæ sobie metody, które w danej klasie s¹ zdefiniowane. 
		  * Pamiêtajmy jednak o tym, i¿ zwracana jest tablica metod publicznych. 
		  */
		 Method[] methods = referencjaNaKonkretnyObiektKlasy.getMethods();
		 for (Method method : methods) {
			 System.out.println("Metoda: " + method.getName() + " liczba parametrów: " + method.getParameterCount());
		 } 
		 
	}
	
	/**
	 * Poni¿sza metoda pokazuje w jaki sposób 
	 * Oprócz wymienionych powy¿ej sposobów uzyskiwania informacji o klasie, 
	 * istnieje mo¿liwoœæ uzyskania dostêpu do listy konstruktorów.
	 */
	public static void statycznaAnalizaKonstruktorow() {
		/*
		 * >>>>>>>>>>>>>>>>>>>>>>> KONSTRUKTORY <<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */
		
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		
		System.out.println("\nStatyczna analiza konstruktorów. 1. Konstruktor.");
		/*
		 * Mo¿emy dobraæ siê do konstruktora danej klasy. Z tej racji ¿e konstruktor z danym zbiorem parametrów 
		 * o konkretnych typach jest tylko jeden, mo¿na go pobraæ podaj¹c typ jego parametrów. 
		 * 
		 */
		try {
			/*
			 * Nale¿y zauwa¿yæ, i¿ typy prymitywne te¿ dostarczaj¹ obiektu klasy (int.class).
			 */
			Constructor<KlasaJakKlasa> constructor = referencjaNaKonkretnyObiektKlasy.getConstructor(int.class);
			System.out.println(" Konstrukltor: " + constructor.getName());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			/*
			 * W przypadku pobrania konstruktora z wiêksz¹ liczb¹ parametrów, nale¿y podaæ ich typy jako lista parametrów. 
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
		  * Mo¿na uzyskaæ dostêp do pakietu w którym znajduje siê dana klasa.  
		  */
		Class<KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy = KlasaJakKlasa.class;
		Package gotPackage = referencjaNaKonkretnyObiektKlasy.getPackage();
		System.out.println("Package: " + gotPackage.getName());
		
		/*
		 * Niech dana bêdzie klasa, do której mamy referencjê zainicjalizowan¹ now¹ instancj¹ obiektu.
		 */
		 KlasaJakKlasa klasaJakKlasa = new KlasaJakKlasa();
		 
		 /*
		  * Mo¿na równie¿ uzyskaæ dostêp do klasy z istniej¹cej instancji.
		  */
		 Class<? extends KlasaJakKlasa> referencjaNaKonkretnyObiektKlasy2 = klasaJakKlasa.getClass();
		 
	}
	
}
