package vblahoz.idc.test.impl.csv;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import vblahoz.idc.test.model.Timescale;

public class TimescaleFactoryTest {

	@Test
	public void fromStringTest() {
		Timescale t = TimescaleFactory.fromString("2010 Q4");
		Assertions.assertAll(() -> {
			Assert.assertEquals(2010, t.getYear());
		}, () -> {
			Assert.assertEquals(4, t.getQuarter());
		});
	}

	@Test
	public void fromStringTest2() {
		Timescale t = TimescaleFactory.fromString("2010      Q4567");
		Assertions.assertAll(() -> {
			Assert.assertEquals(2010, t.getYear());
		}, () -> {
			Assert.assertEquals(4567, t.getQuarter());
		});
	}

	@Test
	public void fromStringFailTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> TimescaleFactory.fromString("2010Q1"));
	}

	@Test
	public void fromStringFailTest2() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> TimescaleFactory.fromString("2010 aQ1"));
	}

	@Test
	public void fromStringFailTest3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> TimescaleFactory.fromString("test Q1"));
	}

	@Test
	public void fromStringFailTest4() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> TimescaleFactory.fromString("2000 Qa"));
	}

	@Test
	public void fromStringFailTest5() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> TimescaleFactory.fromString(null));
	}
}