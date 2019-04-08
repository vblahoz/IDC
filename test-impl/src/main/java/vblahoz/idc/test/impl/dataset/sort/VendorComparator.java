package vblahoz.idc.test.impl.dataset.sort;

import java.util.Comparator;

import vblahoz.idc.test.dataset.DatasetEntry;

/**
 * Compare DatasetEntry by vendor
 * 
 * @author vblahoz
 *
 */
public class VendorComparator implements Comparator<DatasetEntry> {

	@Override
	public int compare(DatasetEntry o1, DatasetEntry o2) {
		return o1.getVendor().toLowerCase().compareTo(o2.getVendor().toLowerCase());
	}

}
