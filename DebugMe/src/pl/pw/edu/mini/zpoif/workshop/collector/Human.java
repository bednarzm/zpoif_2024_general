package pl.pw.edu.mini.zpoif.workshop.collector;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Human {

	private static List<String> names = List.of("Piotr", "Monika", "Stefan", "Alicja", "Adam", "Ewa");
	private static List<String> surnames = List.of("Chobot", "Momot", "Nowak", "Góra", "Rzeka", "Przytyk");
	
	private String name;
	private String surname;
	private int age;
	
	public Human() {
		Random random = new Random();
		name = names.get(random.nextInt(names.size()));
		surname = surnames.get(random.nextInt(surnames.size()));
		age = random.nextInt(100);
	}

	public void printGreeting() {
		System.out.println("Hello my dear reader!");
	}

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", surname=" + surname + "]";
	}

}
