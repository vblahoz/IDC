package vblahoz.idc.test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import vblahoz.idc.test.export.IExporter;
import vblahoz.idc.test.impl.RecordParser;
import vblahoz.idc.test.impl.csv.CSVReader;
import vblahoz.idc.test.impl.dataset.Dataset;
import vblahoz.idc.test.impl.dataset.export.HtmlExporter;
import vblahoz.idc.test.model.Country;
import vblahoz.idc.test.model.Record;
import vblahoz.idc.test.model.Timescale;

public class Test {

	/**
	 * Example usage
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CSVReader reader = new CSVReader();
		List<List<String>> data = reader.read(new FileReader("resources/data.csv"));
		
		RecordParser parser = new RecordParser();
		List<Record> records = parser.parse(data);
		
		Country country = Country.CZECH_REPUBLIC;
		Timescale timescale = new Timescale(2010, 3);
		
		Dataset dataset = new Dataset(records, timescale, country);
		
		IExporter htmlExporter = new HtmlExporter();
		String html = htmlExporter.export(dataset.getData(), country, timescale);
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("resources/export.html"));) {
			writer.write(html);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
