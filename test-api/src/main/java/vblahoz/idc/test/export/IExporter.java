package vblahoz.idc.test.export;

import java.util.List;

import vblahoz.idc.test.dataset.DatasetEntry;
import vblahoz.idc.test.model.Country;
import vblahoz.idc.test.model.Timescale;

/**
 * Exporter interface
 * 
 * @author vblahoz
 *
 */
public interface IExporter {

	/**
	 * Export the data
	 * 
	 * @param data data
	 * @param country country
	 * @param timescale timescale
	 * @return exported data
	 */
	String export(List<DatasetEntry> data, Country country, Timescale timescale);
}
