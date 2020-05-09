package com.sapient.incomefinder;

import org.junit.Test;

import com.sapient.incomefinder.utils.CurrencyConverter;

import static org.junit.Assert.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyConverterTest.
 */
public class CurrencyConverterTest {

	/**
	 * Test currency converter.
	 */
	@Test
	public void testCurrencyConverter(){
		assertEquals(new Float(1),new Float(CurrencyConverter.convert("HKD", "USD", 8)));
		assertEquals(new Float(1),new Float(CurrencyConverter.convert("INR", "USD", 66)));
		assertEquals(new Float(1),new Float(CurrencyConverter.convert("GBP", "USD", (float)0.67)));
		assertEquals(new Float(1),new Float(CurrencyConverter.convert("SGD", "USD", (float)1.5)));
	}
	
}
