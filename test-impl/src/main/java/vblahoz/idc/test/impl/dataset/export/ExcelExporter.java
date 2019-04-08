package vblahoz.idc.test.impl.dataset.export;

import java.util.List;

import vblahoz.idc.test.dataset.DatasetEntry;
import vblahoz.idc.test.export.IExporter;
import vblahoz.idc.test.model.Country;
import vblahoz.idc.test.model.Timescale;

/**
 * Example of different exporter
 * 
 * @author vblahoz
 *
 */
public class ExcelExporter implements IExporter {

	@Override
	public String export(List<DatasetEntry> data, Country country, Timescale timescale) {
		throw new UnsupportedOperationException("Not implemented");
	}

}
