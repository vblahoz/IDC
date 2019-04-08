package vblahoz.idc.test.impl.dataset;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import vblahoz.idc.test.dataset.DatasetEntry;
import vblahoz.idc.test.impl.dataset.sort.UnitsComparator;
import vblahoz.idc.test.model.Sells;

public class UnitsComparatorTest {

	UnitsComparator comparator = new UnitsComparator();
	DatasetEntry entry1 = new DatasetEntry("whatever", new Sells(0f, 0f));
	DatasetEntry entry2 = new DatasetEntry("whatever2", new Sells(1f, 0f));

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
