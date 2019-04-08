package vblahoz.idc.test.impl.dataset;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import vblahoz.idc.test.dataset.DatasetEntry;
import vblahoz.idc.test.impl.dataset.sort.VendorComparator;
import vblahoz.idc.test.model.Sells;

public class VendorComparatorTest {

	VendorComparator comparator = new VendorComparator();
	DatasetEntry entry1 = new DatasetEntry("A", new Sells(0f, 0f));
	DatasetEntry entry2 = new DatasetEntry("B", new Sells(0f, 0f));

	@Test
	public void testCompare() {
		Assert.assertTrue(comparator.compare(entry1, entry2) < 0);
	}

	@Test
	public void testCompare2() {
		Assert.assertTrue(comparator.compare(entry2, entry1) > 0);
	}

	@Test
	public void testCompare3() {
		Assert.assertTrue(comparator.compare(entry1, entry1) == 0);
	}

}
