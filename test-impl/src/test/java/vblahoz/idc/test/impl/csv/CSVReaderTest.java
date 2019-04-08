package vblahoz.idc.test.impl.csv;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import vblahoz.idc.test.impl.csv.CSVReader;

public class CSVReaderTest {

	@Test
	public void test() throws IOException {
		CSVReader reader = new CSVReader();
		InputStreamReader inputReader = new FileReader("resources/test1.csv");
		List<List<String>> data = reader.read(inputReader);

		List<String> header = Arrays.asList("Country", "Timescale", "Vendor", "Units");
		List<String> row1 = Arrays.asList("Czech Republic", "2010 Q3", "Fujitsu Siemens", "2924.742632");
		List<String> row2 = Arrays.asList("Slovakia", "2010 Q4", "Dell", "2525.011404");

		Assertions.assertAll(() -> {
			Assert.assertEquals(data.size(), 3);
		}, () -> {
			Assert.assertEquals(data.get(0), header);
		}, () -> {
			Assert.assertEquals(data.get(1), row1);
		}, () -> {
			Assert.assertEquals(data.get(2), row2);
		});
	}
}
