package com.sapient.incomefinder.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.sapient.incomefinder.dao.CityIncomeDao;
import com.sapient.incomefinder.model.City;
import com.sapient.incomefinder.model.CityIncome;
import com.sapient.incomefinder.model.Country;

// TODO: Auto-generated Javadoc
/**
 * The Class CityIncomeDaoCSV.
 */
public class CityIncomeDaoCSV implements CityIncomeDao {

	/* (non-Javadoc)
	 * @see com.sapient.incomefinder.dao.CityIncomeDao#getCitiesIncome(java.lang.String)
	 */
	@Override
	public List<CityIncome> getCitiesIncome(String fileName) {
		ArrayList<CityIncome> cityIncomes = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(Paths.get(fileName));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
			boolean headerFlag = true;

			for (CSVRecord csvRecord : csvParser) {
				if (headerFlag) {
					headerFlag = false;
					continue;
				}
				CityIncome cityIncome = mapCSVRecordToCityIncome(csvRecord);
				cityIncomes.add(cityIncome);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cityIncomes;

	}

	/**
	 * Map CSV record to city income.
	 *
	 * @param csvRecord the csv record
	 * @return the city income
	 */
	private CityIncome mapCSVRecordToCityIncome(CSVRecord csvRecord) {
		Country country;
		if (csvRecord.get(1).replaceAll("\\s+", "").equals("")) {
			country = null;
		} else {
			country = new Country(csvRecord.get(1));
		}
		City city = new City(csvRecord.get(0), country);
		CityIncome cityIncome = new CityIncome(city, csvRecord.get(2),
				csvRecord.get(3), Float.parseFloat(csvRecord.get(4)));
		return cityIncome;
	}
}
