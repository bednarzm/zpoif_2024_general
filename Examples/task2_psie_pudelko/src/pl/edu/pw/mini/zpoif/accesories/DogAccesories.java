package pl.edu.pw.mini.zpoif.accesories;

public abstract class DogAccesories {

	private String producerName;

	protected static InitHelper initHelper = new InitHelper();

	public DogAccesories() {
		super();
		this.producerName = initHelper.provideRandomProducerNameGenerator().get();
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

}
