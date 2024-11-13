package pl.edu.pw.mini.zpoif.dogBoxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import pl.edu.pw.mini.zpoif.accesories.AnimalFood;
import pl.edu.pw.mini.zpoif.accesories.DogAccesories;
import pl.edu.pw.mini.zpoif.accesories.DogTin;
import pl.edu.pw.mini.zpoif.accesories.FoodPack;
import pl.edu.pw.mini.zpoif.accesories.Gryzak;
import pl.edu.pw.mini.zpoif.accesories.GryzakPiszczacy;

public class MyDogBox {

	protected List<DogAccesories> accesories;
	protected static final Random RANDOM = new Random();

	public MyDogBox() {
		super();
		this.accesories = new ArrayList<DogAccesories>();

		for (int i = 0; i < 20; i++) {
			accesories.add(new Gryzak(false));
			accesories.add(new GryzakPiszczacy(false));
		}

		for (int i = 0; i < 40; i++) {
			accesories.add(new DogTin());
		}

		for (int i = 0; i < 50; i++) {
			accesories.add(new FoodPack());
		}
	}

	public void detectNonAttestationChew() {
		accesories.forEach((x) -> {
			if (x instanceof Gryzak) {
				Gryzak g = (Gryzak) x;
				if (!g.isAttestation()) {
					System.out.println("Brak atestu!!!");
				}
			}
		});
	}

	public void detectCaloricFood() {

		accesories.forEach(new Consumer<DogAccesories>() {
			private int count = 0;

			@Override
			public void accept(DogAccesories t) {
				if (t instanceof AnimalFood animalFood) {
					if (animalFood.getCalories() > 350 && ++count < 32) {
						System.out.println("Uwaga na kalorie");
					}
				}
			}

		});
	}

	public void getSummarizedDryFoodCalories() {

		class CaloriesCount implements Consumer<DogAccesories> {
			private int caloriesCount;

			@Override
			public void accept(DogAccesories t) {
				if (t instanceof FoodPack foodPack) {
					caloriesCount += foodPack.getCalories();
				}
			}

			public int getCaloriesCount() {
				return caloriesCount;
			}

		}

		CaloriesCount caloriesCount = new CaloriesCount();
		accesories.forEach(caloriesCount::accept);
		System.out.println(caloriesCount.getCaloriesCount());
	}

}
