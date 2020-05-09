package com.sapient.incomefinder.utils;

import com.sapient.incomefinder.constants.Currency;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyConverter.
 */
public class CurrencyConverter {

	/**
	 * Convert.
	 *
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * @param amount
	 *            the amount
	 * @return the float
	 */
	public static float convert(String from, String to, float amount) {

		float convertedValue = amount;
		if (from.equals(Currency.INR) && to.equals(Currency.USD)) {
			convertedValue = (float) (amount / (float) 66);
		}
		if (from.equals(Currency.GBP) && to.equals(Currency.USD)) {
			convertedValue = (float) (amount / (float) 0.67);
		}
		if (from.equals(Currency.SGP) && to.equals(Currency.USD)) {
			convertedValue = (float) (amount / (float) 1.5);
		}
		if (from.equals(Currency.HKD) && to.equals(Currency.USD)) {
			convertedValue = (float) (amount / (float) 8);
		}
		if (from.equals(Currency.USD) && to.equals(Currency.USD)) {
			convertedValue = amount;
		}

		return convertedValue;
	}
}
