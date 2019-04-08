package vblahoz.idc.test.model;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class CountryTest {

	@TestFactory
	public List<DynamicTest> getByLabelTestFactory() {
		List<DynamicTest> tests = new ArrayList<>();

		for (Country country : Country.values()) {
			tests.add(dynamicTest(country.getLabel(),
					() -> Assert.assertEquals(country, Country.getByLabel(country.getLabel()))));
		}

		return tests;
	}

}
