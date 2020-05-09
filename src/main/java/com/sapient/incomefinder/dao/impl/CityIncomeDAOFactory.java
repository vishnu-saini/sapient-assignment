package com.sapient.incomefinder.dao.impl;

import com.sapient.incomefinder.constants.FileExtensions;
import com.sapient.incomefinder.dao.CityIncomeDao;
import com.sapient.incomefinder.exception.IncomeFinderApplicationException;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating CityIncomeDAO objects.
 */
public class CityIncomeDAOFactory {

	/**
	 * Gets the city income dao.
	 *
	 * @param dataSourceName the data source name
	 * @return the city income dao
	 * @throws IncomeFinderApplicationException the income finder application exception
	 */
	public static CityIncomeDao getCityIncomeDao(String dataSourceName) throws IncomeFinderApplicationException {
		CityIncomeDao cityIncomeDao = null;
		if (dataSourceName.equals(FileExtensions.CSV)) {
			cityIncomeDao = new CityIncomeDaoCSV();
		} else{
			throw new IncomeFinderApplicationException("Not a valid datasource");
		}
		return cityIncomeDao;
	}
}
