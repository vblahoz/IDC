package vblahoz.idc.test.model;

/**
 * Country enum model class
 * 
 * @author vblahoz
 *
 */
public enum Country {
	CZECH_REPUBLIC("Czech Republic"), SLOVAKIA("Slovakia"), UNKNOWN("Unknown");

	private String label;

	private Country(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	/**
	 * Find by label
	 * 
	 * @param label label
	 * @return found country enum od <code>null</code>
	 */
	public static Country getByLabel(String label) {
		for (Country country : values()) {
			if (country.getLabel().equals(label)) {
				return country;
			}
		}

		return null;
	}

}
