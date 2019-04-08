package vblahoz.idc.test.csv;

import java.util.List;

import vblahoz.idc.test.model.Record;

/**
 * Record parser
 * 
 * @author vblahoz
 *
 */
public interface IRecordParser {

	/**
	 * Parse the data
	 * 
	 * @param data the data
	 * @return collection of records
	 */
	public List<Record> parse(List<List<String>> data);

}
