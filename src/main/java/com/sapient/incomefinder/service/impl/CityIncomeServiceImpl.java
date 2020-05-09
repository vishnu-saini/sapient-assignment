package com.sapient.incomefinder.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sapient.incomefinder.constants.Currency;
import com.sapient.incomefinder.dao.CityIncomeDao;
import com.sapient.incomefinder.model.AverageIncomeRecord;
import com.sapient.incomefinder.model.CityIncome;
import com.sapient.incomefinder.service.CityIncomeService;
import com.sapient.incomefinder.utils.CurrencyConverter;

// TODO: Auto-generated Javadoc
/**
 * The Class CityIncomeServiceImpl.
 */
public class CityIncomeServiceImpl implements CityIncomeService {

	/** The city income dao. */
	CityIncomeDao cityIncomeDao;

	/**
	 * Instantiates a new city income service impl.
	 *
	 * @param cityIncomeDao
	 *            the city income dao
	 */
	public CityIncomeServiceImpl(CityIncomeDao cityIncomeDao) {
		this.cityIncomeDao = cityIncomeDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sapient.incomefinder.service.CityIncomeService#getAverageIncomeByCity
	 * (java.lang.String)
	 */
	@Override
	public List<AverageIncomeRecord> getAverageIncomeByCity(String inputFile) {

		List<CityIncome> cityIncomes = cityIncomeDao.getCitiesIncome(inputFile);
		List<AverageIncomeRecord> averageIncomes = new ArrayList<AverageIncomeRecord>();

		for (CityIncome cityIncome : cityIncomes) {

			String place;

			if (cityIncome.getCity().getCountry() != null) {
				place = cityIncome.getCity().getCountry().getName();
			} else {
				place = cityIncome.getCity().getName();
			}

			float income = CurrencyConverter.convert(cityIncome.getCurrency()
					.trim(), Currency.USD, cityIncome.getAverageIncome());
			AverageIncomeRecord averageIncomeRecord = new AverageIncomeRecord(
					place, cityIncome.getGender(), income);

			AverageIncomeRecord toUpdate = getRecordIfFound(averageIncomes,
					averageIncomeRecord);
			if (toUpdate != null) {
				toUpdate.setTotalSalary(toUpdate.getTotalSalary()
						+ averageIncomeRecord.getTotalSalary());
				toUpdate.setCount(toUpdate.getCount() + 1);
			} else {

				averageIncomeRecord.setCount(1);
				averageIncomes.add(averageIncomeRecord);

			}
		}

		for (AverageIncomeRecord averageIncomeRecord : averageIncomes) {
			averageIncomeRecord.setAverageIncome((float) averageIncomeRecord
					.getTotalSalary() / averageIncomeRecord.getCount());
		}

		Collections.sort(averageIncomes);
		return averageIncomes;
	}

	/**
	 * Gets the record if found.
	 *
	 * @param averageIncomeRecords the average income records
	 * @param toFindRecord the to find record
	 * @return the record if found
	 */
	private AverageIncomeRecord getRecordIfFound(
			List<AverageIncomeRecord> averageIncomeRecords,
			AverageIncomeRecord toFindRecord) {

		AverageIncomeRecord result = null;
		for (AverageIncomeRecord averageIncomeRecord : averageIncomeRecords) {
			if (averageIncomeRecord.equals(toFindRecord)) {
				result = averageIncomeRecord;
				break;
			}
		}
		return result;
	}
}
