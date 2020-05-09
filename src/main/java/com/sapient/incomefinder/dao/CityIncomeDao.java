package com.sapient.incomefinder.dao;

import java.util.List;

import com.sapient.incomefinder.model.CityIncome;

// TODO: Auto-generated Javadoc
/**
 * The Interface CityIncomeDao.
 */
public interface CityIncomeDao {

	/**
	 * Gets the cities income.
	 *
	 * @param fileName the file name
	 * @return the cities income
	 */
	List<CityIncome> getCitiesIncome(String fileName);
}
