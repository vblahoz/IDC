package vblahoz.idc.test.impl.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import vblahoz.idc.test.csv.IReader;

public class CSVReader implements IReader {

	private static final String DELIMITER = ",";

	@Override
	public List<List<String>> read(InputStreamReader reader) throws IOException {
		List<List<String>> rows = new LinkedList<>();

		try (BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(DELIMITER);
				List<String> row = new LinkedList<>();
				for (String cell : values) {
					row.add(cell.trim());
				}

				rows.add(row);
			}
		}
		return rows;
	}

}
