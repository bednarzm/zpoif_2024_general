package pl.edu.pw.mini.zpoif.assignments.fourth.okrety.generator;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.Korweta;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.Okret;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretDesantowy;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretHydrograficzny;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretPodwodny;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.NiszczycielMin;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.Tralowiec;

public class GeneratorOkretow {

	public static List<Okret> generujOkrety() {
		List<Okret> result = new ArrayList<>();

		result.add(new OkretPodwodny("ORP Sep", 524, 48.74f, 3800, 10, 2120, 8, false));
		result.add(new Korweta("ORP Piorun", 369, 48.9f, 4500, 36, 11910, 2));
		result.add(new OkretHydrograficzny("ORP Heweliusz", 1214, 61.6f, 5500, 13, 1400));
		result.add(new OkretDesantowy("ORP Krakow", 1675, 95.8f, 1500, 16, 3960, 2.3f));
		result.add(new OkretHydrograficzny("ORP Arctowski", 1214, 61.6f, 5500, 13, 1400));
		result.add(new OkretDesantowy("ORP Poznan", 1675, 95.8f, 1400, 16, 3960, 2.38f));
		result.add(new Tralowiec("ORP Goplo", 225, 38.5f, 1500, 14, 2000, true));
		result.add(new Tralowiec("ORP Czajka", 470, 58.2f, 2000, 19, 3600, false));
		result.add(new OkretPodwodny("ORP Orzel", 3180, 72.6f, 6000, 17, 5500, 18, true));
		result.add(new Korweta("ORP Orkan", 369, 48.9f, 4500, 36, 11880, 4));
		result.add(new Tralowiec("ORP Sniardwy", 216, 38.5f, 1500, 14, 2000, true));
		result.add(new Tralowiec("ORP Resko", 217, 38.47f, 950, 15, 2000, false));
		result.add(new OkretDesantowy("ORP Torun", 1675, 95.8f, 1400, 17, 3960, 2.38f));
		result.add(new OkretPodwodny("ORP Sep", 524, 48.74f, 3800, 10, 2120, 8, false));
		result.add(new Korweta("ORP Grom", 369, 48.9f, 1700, 36, 11880, 4));
		result.add(new NiszczycielMin("ORP Kormoran", 900, 58.5f, 2500, 15, 4500));
		result.add(new Tralowiec("ORP Wdzydze", 217, 38.47f, 1500, 14, 2000, true));
		result.add(new Tralowiec("ORP Wigry", 217, 38.47f, 1500, 14, 2000, true));
		result.add(new OkretDesantowy("ORP Gniezno", 1665, 95.8f, 850, 17, 4150, 2.0f));
		result.add(new OkretDesantowy("ORP Lublin", 1675, 95.8f, 1400, 17, 3960, 2.38f));
		result.add(new Tralowiec("ORP Mamry", 216, 38.5f, 1500, 14, 2000, true));
		result.add(new OkretDesantowy("ORP Torun", 1675, 95.8f, 1400, 17, 3960, 2.38f));
		result.add(new OkretPodwodny("ORP Bielik", 524, 48.74f, 3800, 10, 2120, 8, false));
		result.add(new Korweta("ORP Gen. T. Kosciuszko", 3658, 135.6f, 4500, 30, 80000, 2));
		result.add(new Tralowiec("ORP Gardno", 206, 38.47f, 793, 14, 2000, false));
		result.add(new OkretHydrograficzny("ORP Hydrograf", 1675, 73.3f, 7200, 17, 3600));
		result.add(new Korweta("ORP Kaszub", 1183, 82.34f, 3500, 26, 68800, 2));
		result.add(new Tralowiec("ORP Flaming", 470, 58.2f, 2000, 17, 3600, false));
		result.add(new Korweta("ORP Gen. T. Pulaski", 4100, 135.6f, 5000, 29, 82000, 2));
		result.add(new Tralowiec("ORP Goplo", 225, 38.5f, 1500, 14, 2000, true));
		result.add(new OkretDesantowy("ORP Gniezno", 1665, 95.8f, 850, 17, 4150, 2.0f));

		return result;
	}

}
