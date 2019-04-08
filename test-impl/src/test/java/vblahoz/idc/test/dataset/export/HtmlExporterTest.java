package vblahoz.idc.test.dataset.export;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import vblahoz.idc.test.dataset.DatasetEntry;
import vblahoz.idc.test.impl.dataset.export.HtmlExporter;
import vblahoz.idc.test.model.Country;
import vblahoz.idc.test.model.Sells;
import vblahoz.idc.test.model.Timescale;

public class HtmlExporterTest {

	private static final String RESULT = "<!DOCTYPE html>"
			+ "<html lang=\"en\">"
			+ "<head>"
			+ "<meta charset=\"utf-8\">"
			+ "<title>PC Quarterly Market Share</title>"
			+ "<style>"
			+ "table {width: 90%;border-collapse:collapse;border-spacing:0;margin-left: auto;margin-right: auto;}"
			+ "caption {text-align: left;padding-left: 2em;}"
			+ "td, th{border: 1px solid black;text-align: center;font-family:sans-serif;font-weight:500;padding-top:3px;padding-bottom:3px;}"
			+ ".total { background-color : rgb(255,255,153)}"
			+ "th { background-color: rgb(217,217,217)}"
			+ "</style>"
			+ "</head>"
			+ "<body>"
			+ "<table cellspacing='-1px'>"
			+ "<caption>Table 1, PC Quarterly Market Share, the Czech Republic, 4Q10</caption>"
			+ "<tr><th>Vendor</th><th>Units</th><th>Share</th></tr>"
			+ "<tr><td>IBM</td><td>15,000</td><td>13.4%</td></tr>"
			+ "<tr><td>Dell</td><td>12,030</td><td>10.7%</td></tr>"
			+ "<tr><td>HP</td><td>11,000</td><td>9.7%</td></tr>"
			+ "<tr><td>Others</td><td>75,001</td><td>66.0%</td></tr>"
			+ "<tr class='total'><td>Total</td><td>113,032</td> <td>100%</td></tr>"
			+ "</table>"
			+ "</body>"
			+ "</html>";
	
	@Test
	public void testExport() {
		DatasetEntry entry1 = new DatasetEntry("IBM", new Sells(15000.123456f, 13.35456f));
		DatasetEntry entry2 = new DatasetEntry("Dell", new Sells(12030.45495f, 10.656745f));
		DatasetEntry entry3 = new DatasetEntry("HP", new Sells(11000.45789456f, 9.7015354f));
		DatasetEntry entry4 = new DatasetEntry("Others", new Sells(75000.784568f, 66.012135f));
		
		List<DatasetEntry> entries = new ArrayList<>();
		entries.add(entry1);
		entries.add(entry2);
		entries.add(entry3);
		entries.add(entry4);
		
		String data = (new HtmlExporter()).export(entries, Country.CZECH_REPUBLIC, new Timescale(2010, 4));
		
		Assert.assertEquals(RESULT, data);
	}
	
}
