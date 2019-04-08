package vblahoz.idc.test.impl.csv;

import vblahoz.idc.test.model.Timescale;

/**
 * Timescale factory
 * 
 * @author vblahoz
 *
 */
public class TimescaleFactory {

	/**
	 * Parser from string representation. Legal format is "YYYY Qn", where YYYY is
	 * year representation and 'n' is quarter number. The year and the quarter are
	 * separated by one or more white spaces
	 * 
	 * @param label string representation
	 * @return timescale
	 */
	public static Timescale fromString(String label) {
		if (label == null) {
			throw new IllegalArgumentException("Timescale is null");
		}

		String[] parts = label.trim().split("\\s+");

		if (parts.length != 2) {
			throw new IllegalArgumentException("Invalid timescale format");
		}

		int year = Integer.parseInt(parts[0]);

		if (!parts[1].startsWith("Q")) {
			throw new IllegalArgumentException("Invalid timescale quarter format");
		}

		int quarter = Integer.parseInt(parts[1].substring(1));

		return new Timescale(year, quarter);

	}
}
