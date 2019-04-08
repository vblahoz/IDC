package vblahoz.idc.test.impl.dataset.export;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import vblahoz.idc.test.dataset.DatasetEntry;
import vblahoz.idc.test.export.IExporter;
import vblahoz.idc.test.model.Country;
import vblahoz.idc.test.model.Timescale;

public class HtmlExporter implements IExporter {

	private static DecimalFormat unitsFormatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
	private static DecimalFormat shareFormatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
	
	static {
		unitsFormatter.setMaximumFractionDigits(0);
		shareFormatter.setMaximumFractionDigits(1);
		shareFormatter.setMinimumFractionDigits(1);
		shareFormatter.setPositiveSuffix("%");
	}
	
	private static final String TEMPLATE = "<!DOCTYPE html>" + 
			"<html lang=\"en\">" + 
			"<head>" + 
			"<meta charset=\"utf-8\">" + 
			"<title>PC Quarterly Market Share</title>" + 
			"<style>" +
			"table {width: 90%%;border-collapse:collapse;border-spacing:0;margin-left: auto;margin-right: auto;}" +
			"caption {text-align: left;padding-left: 2em;}" +
			"td, th{border: 1px solid black;text-align: center;font-family:sans-serif;font-weight:500;padding-top:3px;padding-bottom:3px;}" +
			".total { background-color : rgb(255,255,153)}" +
			"th { background-color: rgb(217,217,217)}" +
			"</style>" + 
			"</head>" + 
			"<body>" + 
			"<table cellspacing='-1px'>" +
			"<caption>Table 1, PC Quarterly Market Share, the %s, %s</caption>" +
			"<tr>" + 
			"<th>Vendor</th>" + 
			"<th>Units</th>" + 
			"<th>Share</th>" + 
			"</tr>" + 
			"%s" +
			"<tr class='total'>" + 
			"<td>Total</td>" + 
			"<td>%s</td> " + 
			"<td>100%%</td>" + 
			"</tr>" + 
			"</table>" +
			"</body>" + 
			"</html>";
	
	@Override
	public String export(List<DatasetEntry> data, Country country, Timescale timescale) {
		float totalUnits = 0;

		StringBuilder rowsBuilder = new StringBuilder();

		for (DatasetEntry entry : data) {
			totalUnits += entry.getSells().getUnits();
			rowsBuilder.append(createRow(entry));
		}
		
		return String.format(TEMPLATE, country.getLabel(), formatTimescale(timescale), rowsBuilder.toString(), unitsFormatter.format(totalUnits));
	}
	
	private String formatTimescale(Timescale timescale) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, timescale.getYear());
		
		DateFormat df = new SimpleDateFormat("yy");
		String formattedDate = df.format(calendar.getTime());
		
		return String.format("%dQ%s", timescale.getQuarter(), formattedDate);
	}


	private String createRow(DatasetEntry entry) {
		StringBuilder sb = new StringBuilder("<tr><td>");
		sb.append(entry.getVendor());
		sb.append("</td><td>");
		sb.append(unitsFormatter.format(entry.getSells().getUnits()));
		sb.append("</td><td>");
		sb.append(shareFormatter.format(entry.getSells().getShare()));
		sb.append("</td></tr>");
		
		return sb.toString();
	}

}
