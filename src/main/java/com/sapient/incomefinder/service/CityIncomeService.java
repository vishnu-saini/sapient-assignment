package com.sapient.incomefinder.service;

import java.util.List;

import com.sapient.incomefinder.model.AverageIncomeRecord;

// TODO: Auto-generated Javadoc
/**
 * The Interface CityIncomeService.
 */
public interface CityIncomeService {

	/**
	 * Gets the average income by city.
	 *
	 * @param inputFile the input file
	 * @return the average income by city
	 */
	List<AverageIncomeRecord> getAverageIncomeByCity(String inputFile);
}
