package model;

public class CalculatorModel {

	private StringBuilder binaryInteger = new StringBuilder();

	/**
	 * Dezimalzahlen in Binärzahlen umwandeln und ausgeben.
	 * 
	 * @param input Unsaubere Zeichenkette.
	 * @return
	 */
	public String convertIntToBin(String input) {
		this.binaryInteger.setLength(0);

		if (!input.matches("[0-9]+"))
			throw new NumberFormatException("Nur positive ganze Zahlen erlaubt!");

		int x = Integer.parseInt(input);
		if (x == 0)
			this.binaryInteger.append(x);

		while (x >= 1) {
			this.binaryInteger.append(x % 2);
			x = (x / 2);
		}

		return this.binaryInteger.reverse().toString();

	}

}
