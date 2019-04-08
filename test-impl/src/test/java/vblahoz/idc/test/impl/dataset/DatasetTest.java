package vblahoz.idc.test.impl.dataset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import vblahoz.idc.test.model.Country;
import vblahoz.idc.test.model.Record;
import vblahoz.idc.test.model.Timescale;

public class DatasetTest {

	private static Dataset dataset;

	@BeforeAll
	private static void setup() {
		Record row = new Record(Country.CZECH_REPUBLIC, new Timescale(2000, 1), "Dell", 123.784f);
		Record row2 = new Record(Country.CZECH_REPUBLIC, new Timescale(2000, 2), "Acer", 3f);
		Record row3 = new Record(Country.SLOVAKIA, new Timescale(2000, 1), "Dell", 100.555f);
		Record row4 = new Record(Country.SLOVAKIA, new Timescale(1999, 1), "Acer", 545.777f);
		Record row5 = new Record(Country.CZECH_REPUBLIC, new Timescale(2000, 1), "Acer", 888.999f);
		Record row6 = new Record(Country.CZECH_REPUBLIC, new Timescale(2000, 1), "ASUS", 12.0000f);

		List<Record> records = new ArrayList<>();
		records.add(row);
		records.add(row2);
		records.add(row3);
		records.add(row4);
		records.add(row5);
		records.add(row6);

		dataset = new Dataset(records, new Timescale(2000, 1), Country.CZECH_REPUBLIC);
	}

	@Test
	public void dontFindTest() {
		Assert.assertEquals(-1, dataset.getVendorRow("Apple"));
	}

	@Test
	public void getSellsTest() {
		Assertions.assertAll(() -> {
			Assert.assertEquals(123.783996f, dataset.getSells("Dell").getUnits(), 0.000001);
		}, () -> {
			Assert.assertEquals(888.999023f, dataset.getSells("Acer").getUnits(), 0.000001);
		}, () -> {
			Assert.assertEquals(12.00000f, dataset.getSells("ASUS").getUnits(), 0.000001);
		});
	}

	@Test
	public void getShareTest() {
		Assertions.assertAll(() -> {
			Assert.assertEquals(12.079045f, dataset.getSells("Dell").getShare(), 0.000001);
		}, () -> {
			Assert.assertEquals(86.749984f, dataset.getSells("Acer").getShare(), 0.000001);
		}, () -> {
			Assert.assertEquals(1.170979f, dataset.getSells("ASUS").getShare(), 0.000001);
		});
	}

	@Test
	public void sortVendorTest() {
		dataset.sortByVendor();
		Assertions.assertAll(() -> {
			Assert.assertEquals(1, dataset.getVendorRow("Acer"));
		}, () -> {
			Assert.assertEquals(3, dataset.getVendorRow("Dell"));
		}, () -> {
			Assert.assertEquals(2, dataset.getVendorRow("ASUS"));
		});
	}

	@Test
	public void sortUnitsTest() {
		dataset.sortByUnits();
		Assertions.assertAll(() -> {
			Assert.assertEquals(1, dataset.getVendorRow("ASUS"));
		}, () -> {
			Assert.assertEquals(2, dataset.getVendorRow("Dell"));
		}, () -> {
			Assert.assertEquals(3, dataset.getVendorRow("Acer"));
		});

	}
}
