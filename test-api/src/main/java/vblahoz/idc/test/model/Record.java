package vblahoz.idc.test.model;

/**
 * Model class for data record
 * 
 * @author vblahoz
 *
 */
public class Record {

	private Country country;
	private Timescale timescale;
	private String vendor;
	private Float units;

	public Record(Country country, Timescale timescale, String vendor, Float units) {
		super();
		this.country = country;
		this.timescale = timescale;
		this.vendor = vendor;
		this.units = units;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @return the timescale
	 */
	public Timescale getTimescale() {
		return timescale;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @return the units
	 */
	public float getUnits() {
		return units;
	}

}
