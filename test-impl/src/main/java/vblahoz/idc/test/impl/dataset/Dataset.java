package vblahoz.idc.test.impl.dataset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vblahoz.idc.test.dataset.DatasetEntry;
import vblahoz.idc.test.impl.dataset.sort.UnitsComparator;
import vblahoz.idc.test.impl.dataset.sort.VendorComparator;
import vblahoz.idc.test.model.Country;
import vblahoz.idc.test.model.Record;
import vblahoz.idc.test.model.Sells;
import vblahoz.idc.test.model.Timescale;

/**
 * Dataset aggregating data for vendors and able to sort and lookup the data
 * 
 * @author vblahoz
 *
 */
public class Dataset {

	private Comparator<DatasetEntry> vendorComparator = new VendorComparator();
	private Comparator<DatasetEntry> unitsComparator = new UnitsComparator();

	private Timescale timescale;
	private Country country;
	private List<DatasetEntry> data = new ArrayList<>();

	public Dataset(List<Record> inputData, Timescale timescale, Country country) {
		this.timescale = timescale;
		this.country = country;
		process(inputData);
	}

	/**
	 * Aggregate all data for same vendor in given timescale into map
	 */
	private void process(List<Record> inputData) {
		List<Record> tmp = new ArrayList<>();

		float totalSells = 0;

		for (Record record : inputData) {
			if (record.getTimescale().equals(timescale) && record.getCountry().equals(country)) {
				totalSells += record.getUnits();

				tmp.add(record);
			}
		}

		for (Record record : tmp) {
			float share = record.getUnits() * 100 / totalSells;
			data.add(new DatasetEntry(record.getVendor(), new Sells(record.getUnits(), share)));
		}

	}

	/**
	 * Finds row index for given vendor
	 * 
	 * @param vendor vendor name
	 * @return row index (1-based) or <code>-1</code> if no such row is found
	 */
	public int getVendorRow(String vendor) {
		for (int i = 0; i < data.size(); i++) {
			DatasetEntry record = data.get(i);
			if (record.getVendor().equals(vendor)) {
				return i + 1;
			}
		}

		return -1;
	}

	/**
	 * Get the number of cells of given vendor
	 * 
	 * @param vendor vendor
	 * @return number of sells or empty sells object if none is found
	 */
	public Sells getSells(String vendor) {
		// WATCH OUT, the vendor row gets returned 1-based
		int index = getVendorRow(vendor) - 1;

		if (index < 0) {
			return Sells.EMPTY_SELLS;
		}

		return data.get(index).getSells();
	}

	/**
	 * Sort the data alphabetically by vendor name
	 */
	public void sortByVendor() {
		Collections.sort(data, vendorComparator);
	}

	/**
	 * Sort the data by number of sold units
	 */
	public void sortByUnits() {
		Collections.sort(data, unitsComparator);
	}
	
	/**
	 * @return the data
	 */
	public List<DatasetEntry> getData() {
		return this.data;
	}

}
