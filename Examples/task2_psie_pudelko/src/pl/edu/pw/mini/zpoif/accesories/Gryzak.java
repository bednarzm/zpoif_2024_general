package pl.edu.pw.mini.zpoif.accesories;

public class Gryzak extends DogAccesories {

	private boolean attestation;

	public Gryzak(boolean attestation) {
		super();
		this.attestation = initHelper.provideRandomAttestationGenerator(attestation).get();
	}

	public boolean isAttestation() {
		return attestation;
	}

}
