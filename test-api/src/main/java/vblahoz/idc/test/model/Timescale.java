package vblahoz.idc.test.model;

/**
 * Model class for timescale representing year and quarter
 * 
 * @author vblahoz
 *
 */
public class Timescale {

	private int year;
	private int quarter;

	public Timescale(int year, int quarter) {
		this.year = year;
		this.quarter = quarter;
	}

	/**
	 * Get the quarter year
	 * 
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Get the quarter
	 * 
	 * @return the quarter
	 */
	public int getQuarter() {
		return this.quarter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quarter;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timescale other = (Timescale) obj;
		if (quarter != other.quarter)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
