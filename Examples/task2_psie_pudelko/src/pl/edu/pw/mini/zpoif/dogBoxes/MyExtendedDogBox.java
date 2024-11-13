package pl.edu.pw.mini.zpoif.dogBoxes;

import pl.edu.pw.mini.zpoif.accesories.DogAccesories;
import pl.edu.pw.mini.zpoif.accesories.DogTin;
import pl.edu.pw.mini.zpoif.accesories.GryzakPiszczacy;
import pl.edu.pw.mini.zpoif.accesories.GryzakPiszczacy.SqueezeFrequency;

public class MyExtendedDogBox extends MyDogBox {

	public void upgradeProducerName(String newName) {
		accesories.forEach((x) -> {
			if (x.getProducerName().length() < 5) {
				x.setProducerName(newName);
			}
		});
	}

	public void upgradeFrequency4All() {

		SqueezeFrequency freq = SqueezeFrequency.values()[RANDOM.nextInt(SqueezeFrequency.values().length)];
		accesories.forEach((x) -> {
			if (x instanceof GryzakPiszczacy) {
				GryzakPiszczacy g = (GryzakPiszczacy) x;
				g.setSquezeFrequency(freq);
			}
		});
	}

	public void getAverageWetFoodCalories() {
		class ResultWrapper {
			private int tins;
			private double calories;

			public void increaseTins() {
				tins++;
			}

			public void increaseCalories(int calories) {
				this.calories += calories;
			}

			public double getAverage() {
				return calories / tins;
			}
		}
		ResultWrapper resultWrapper = new ResultWrapper();

		accesories.forEach(a -> {
			if (a instanceof DogTin) {
				resultWrapper.increaseTins();
				DogTin dogTin = (DogTin) a;
				resultWrapper.increaseCalories(dogTin.getCalories());
			}
		});

		System.out.println("Srednia wartosc kaloryczna w puszkach: " + resultWrapper.getAverage());
	}

}
