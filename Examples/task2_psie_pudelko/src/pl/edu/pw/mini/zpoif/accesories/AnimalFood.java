package pl.edu.pw.mini.zpoif.accesories;

public abstract class AnimalFood extends DogAccesories {

	protected int calories;

	public AnimalFood(int x, int y) {
		super();
		this.calories = initHelper.provideRandomCaloriesValue().getCalories(x, y);
	}

	public int getCalories() {
		return calories;
	}

}
