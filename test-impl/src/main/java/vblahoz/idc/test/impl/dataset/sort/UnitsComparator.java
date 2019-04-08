package vblahoz.idc.test.impl.dataset.sort;

import java.util.Comparator;

import vblahoz.idc.test.dataset.DatasetEntry;

/**
 * Compare DatasetEntry by sold units
 * 
 * @author vblahoz
 *
 */
public class UnitsComparator implements Comparator<DatasetEntry> {

	@Override
	public int compare(DatasetEntry o1, DatasetEntry o2) {
		return Float.compare(o1.getSells().getUnits(), o2.getSells().getUnits());
	}

}
