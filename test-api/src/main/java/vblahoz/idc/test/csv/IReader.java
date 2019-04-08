package vblahoz.idc.test.csv;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Input reader
 * 
 * @author vblahoz
 *
 */
public interface IReader {

	/**
	 * Read the input stream.
	 * 
	 * @param reader input stream reader
	 * @return the collection of lines
	 * @throws IOException exception while reading
	 */
	public List<List<String>> read(InputStreamReader reader) throws IOException;
}
