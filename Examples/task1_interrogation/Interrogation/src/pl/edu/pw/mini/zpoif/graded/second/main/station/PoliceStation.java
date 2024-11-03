package pl.edu.pw.mini.zpoif.graded.second.main.station;

import java.util.List;
import java.util.Random;

import pl.edu.pw.mini.zpoif.graded.second.main.interrogated.Interrogated;
import pl.edu.pw.mini.zpoif.graded.second.main.investigator.Investigator;

public abstract class PoliceStation {

	protected int interrogationTime = 25 + (new Random()).nextInt(5);
	public static final String MOTTO = "To protect and serve";

	protected interface Summaryable {
		public abstract int getNumberOfInterrogatedPeople();
	}

	protected abstract void handleInterrogatedPeople(List<Interrogated> interrogators);

	protected abstract void interrogationRoom1(Interrogated interrogated, Investigator investigator);

	protected abstract void interrogationRoom2(Interrogated interrogated, Investigator investigator);

	protected abstract void interrogationRoom3(Interrogated interrogated, Investigator investigator);

	protected abstract void secretInterrogationRoom(Interrogated interrogated);

	protected abstract void summary(Summaryable summaryable);

	public class Policeman extends Investigator {
		@Override
		public void interrogate(Interrogated interrogated) {
			System.out.println("Mamy " + PoliceStation.this.interrogationTime + "minut");
			super.interrogate(interrogated);
		}
	}

	private static class Intern extends Investigator {

	}
}
