package pl.edu.pw.mini.zpoif.accesories;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import pl.edu.pw.mini.zpoif.accesories.GryzakPiszczacy.SqueezeFrequency;

public class InitHelper {

	protected static final Random RANDOM = new Random();
	private static final List<String> producerNames = List.of("DINGO", "FAFIK", "My pet", "LAPA", "CERBER", "raBIES");

	public InitHelper() {
		super();
	}
	
	public Supplier<String> provideRandomProducerNameGenerator(){
		Supplier<String> supplier = () -> {return producerNames.get(RANDOM.nextInt(producerNames.size()));};
		return supplier;
	}

	public Supplier<SqueezeFrequency> provideRandomFrequencyGenerator(){
		Supplier<SqueezeFrequency> supplier = () -> {return SqueezeFrequency.values()[RANDOM.nextInt(SqueezeFrequency.values().length)];};
		return supplier;
	}

	@FunctionalInterface
	public interface Atestation {
		boolean get();
	}

	public Atestation provideRandomAttestationGenerator(boolean alwaysTrue){
		Atestation supplier = () -> {return alwaysTrue ? true : RANDOM.nextInt(100) < 5 ? false : true;};
		return supplier;
	}

	@FunctionalInterface
	public interface CaloriesScope {
		int getCalories(int x, int y);
	}

	public CaloriesScope provideRandomCaloriesValue(){
		CaloriesScope supplier = (x, y) -> {return RANDOM.nextInt(y - x + 1) + x;};
		return supplier;
	}

}
