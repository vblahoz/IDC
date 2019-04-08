package vblahoz.idc.test.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import vblahoz.idc.test.impl.RecordParser;
import vblahoz.idc.test.model.Country;
import vblahoz.idc.test.model.Record;
import vblahoz.idc.test.model.Timescale;

public class RecordParserTest {

	private static List<Record> records;

	@BeforeAll
	private static void setup() {
		RecordParser parser = new RecordParser();

		List<String> header = Arrays.asList("Country", "Timescale", "Vendor", "Units");
		List<String> row1 = Arrays.asList("Czech Republic", "2010 Q3", "Fujitsu Siemens", "2924.742632");
		List<String> row2 = Arrays.asList("Slovakia", "2010 Q4", "Dell", "2525.011404");

		List<List<String>> rows = new ArrayList<>();
		rows.add(header);
		rows.add(row1);
		rows.add(row2);

		records = parser.parse(rows);
	}

	@Test
	public void rowsCountTest() {
		Assert.assertEquals(2, records.size());
	}

	@Test
	public void countryTest() {
		Assertions.assertAll(() -> Assert.assertEquals(Country.CZECH_REPUBLIC, records.get(0).getCountry()),
				() -> Assert.assertEquals(Country.SLOVAKIA, records.get(1).getCountry()));
	}

	@Test
	public void timescaleTest() {
		Timescale timescale1 = new Timescale(2010, 3);
		Timescale timescale2 = new Timescale(2010, 4);

		Assertions.assertAll(() -> Assert.assertEquals(timescale1, records.get(0).getTimescale()),
				() -> Assert.assertEquals(timescale2, records.get(1).getTimescale()));
	}

	@Test
	public void vendorTest() {
		Assertions.assertAll(() -> Assert.assertEquals("Fujitsu Siemens", records.get(0).getVendor()),
				() -> Assert.assertEquals("Dell", records.get(1).getVendor()));
	}

	@Test
	public void unitsTest() {
		Assertions.assertAll(() -> Assert.assertEquals(2924.742632f, records.get(0).getUnits(), 0.0000001f),
				() -> Assert.assertEquals(2525.011404f, records.get(1).getUnits(), 0.0000001f));
	}

	@Test
	public void nullVendorTest() {
		RecordParser parser = new RecordParser();

		List<String> header = Arrays.asList("Country", "Timescale", "Vendor", "Units");
		List<String> row1 = Arrays.asList("Czech Republic", "2010 Q3", null, "2924.742632");

		List<List<String>> rows = new ArrayList<>();
		rows.add(header);
		rows.add(row1);

		Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(rows));
	}

	@Test
	public void nullTimescaleTest() {
		RecordParser parser = new RecordParser();

		List<String> header = Arrays.asList("Country", "Timescale", "Vendor", "Units");
		List<String> row1 = Arrays.asList("Czech Republic", null, "Fujitsu Siemens", "2924.742632");

		List<List<String>> rows = new ArrayList<>();
		rows.add(header);
		rows.add(row1);

		Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(rows));
	}

	@Test
	public void nullUnitsTest() {
		RecordParser parser = new RecordParser();

		List<String> header = Arrays.asList("Country", "Timescale", "Vendor", "Units");
		List<String> row1 = Arrays.asList("Czech Republic", "2010 Q3", "Fujitsu Siemens", null);

		List<List<String>> rows = new ArrayList<>();
		rows.add(header);
		rows.add(row1);

		Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(rows));
	}

	@Test
	public void nullCountryTest() {
		RecordParser parser = new RecordParser();

		List<String> header = Arrays.asList("Country", "Timescale", "Vendor", "Units");
		List<String> row1 = Arrays.asList(null, "2010 Q3", "Fujitsu Siemens", "2924.742632");

		List<List<String>> rows = new ArrayList<>();
		rows.add(header);
		rows.add(row1);

		Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(rows));
	}

	@Test
	public void nullInvalidUnitsTest() {
		RecordParser parser = new RecordParser();

		List<String> header = Arrays.asList("Country", "Timescale", "Vendor", "Units");
		List<String> row1 = Arrays.asList("Czech Republic", "2010 Q3", "Fujitsu Siemens", "abcde");

		List<List<String>> rows = new ArrayList<>();
		rows.add(header);
		rows.add(row1);

		Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(rows));
	}
}
