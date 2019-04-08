package vblahoz.idc.test.dataset;

import vblahoz.idc.test.model.Sells;

/**
 * Dataset entry
 * 
 * @author vblahoz
 *
 */
public class DatasetEntry {

	private String vendor;
	private Sells sells;

	public DatasetEntry(String vendor, Sells sells) {
		this.vendor = vendor;
		this.sells = sells;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @return the sells
	 */
	public Sells getSells() {
		return sells;
	}
}
