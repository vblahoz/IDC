package vblahoz.idc.test.model;

/**
 * Model class for sells representing number of sold units and share
 * 
 * @author vblahoz
 *
 */
public class Sells {
	public static Sells EMPTY_SELLS = new Sells(0f, 0f);

	private float units;
	private float share;

	public Sells(float units, float share) {
		super();
		this.units = units;
		this.share = share;
	}

	/**
	 * @return the units
	 */
	public float getUnits() {
		return units;
	}

	/**
	 * @return the share
	 */
	public float getShare() {
		return share;
	}
}
