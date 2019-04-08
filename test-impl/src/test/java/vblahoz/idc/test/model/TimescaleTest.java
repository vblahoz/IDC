package vblahoz.idc.test.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TimescaleTest {

	@Test
	public void equalsTest() {
		Timescale t1 = new Timescale(2000, 1);
		Timescale t2 = new Timescale(2000, 1);

		Assert.assertEquals(t1, t2);
	}

	@Test
	public void notEqualsQuarterTest() {
		Timescale t1 = new Timescale(2000, 1);
		Timescale t2 = new Timescale(2000, 2);

		Assert.assertNotEquals(t1, t2);
	}

	@Test
	public void notEqualsYearTest() {
		Timescale t1 = new Timescale(0, 2);
		Timescale t2 = new Timescale(2000, 2);

		Assert.assertNotEquals(t1, t2);
	}
}
