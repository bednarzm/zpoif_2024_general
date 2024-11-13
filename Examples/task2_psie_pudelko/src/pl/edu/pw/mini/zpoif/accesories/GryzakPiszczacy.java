package pl.edu.pw.mini.zpoif.accesories;

public class GryzakPiszczacy extends Gryzak {

	private SqueezeFrequency squezeFrequency;
	
	public enum SqueezeFrequency {
		F16(16), F18(18), F20(20), F22(22), F24(24);
		
		private int value;

		private SqueezeFrequency(int value) {
			this.value = value;
		}
	}
	
	public GryzakPiszczacy(boolean attestation) {
		super(attestation);
		this.squezeFrequency = initHelper.provideRandomFrequencyGenerator().get();
	}

	public void setSquezeFrequency(SqueezeFrequency squezeFrequency) {
		this.squezeFrequency = squezeFrequency;
	}

}
