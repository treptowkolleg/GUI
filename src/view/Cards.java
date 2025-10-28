package view;

public enum Cards {

	CALCULATOR("CALC", "Zahlensystem-Konverter"), RLE("RLE", "Lauflängenverschlüsselung");

	private final String label;

	private final String description;

	Cards(String label, String description) {
		this.label = label;
		this.description = description;
	}

	public String getLabel() {
		return this.label;
	}

	public String getDescription() {
		return this.description;
	}

	public String toString() {
		return this.getLabel();
	}

}
