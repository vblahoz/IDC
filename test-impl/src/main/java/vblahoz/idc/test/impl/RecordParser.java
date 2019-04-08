package vblahoz.idc.test.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import vblahoz.idc.test.csv.IRecordParser;
import vblahoz.idc.test.impl.csv.TimescaleFactory;
import vblahoz.idc.test.model.Country;
import vblahoz.idc.test.model.Record;
import vblahoz.idc.test.model.Timescale;

/**
 * Record parser implementation
 * 
 * @author vblahoz
 *
 */
public class RecordParser implements IRecordParser {

	@Override
	public List<Record> parse(List<List<String>> data) {
		return data.stream().skip(1).map(this::parseRow).collect(Collectors.toCollection(() -> new ArrayList<>()));
	}

	private Record parseRow(List<String> row) {
		if (row.size() != 4) {
			throw new IllegalArgumentException("Invalid number of records in given row: " + row);
		}

		Country country = Country.getByLabel(row.get(0));
		Timescale timescale = TimescaleFactory.fromString(row.get(1));
		String vendor = row.get(2);
		Float units = Float.valueOf(row.get(3) != null ? row.get(3) : "NaN");

		if (country == null || timescale == null || vendor == null || units == null || units.isNaN()) {
			throw new IllegalArgumentException("Null values are not allowed for data cells");
		}

		return new Record(country, timescale, vendor, units);
	}

}
