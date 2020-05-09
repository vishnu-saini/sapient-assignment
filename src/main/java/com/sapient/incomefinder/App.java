package com.sapient.incomefinder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.sapient.incomefinder.dao.CityIncomeDao;
import com.sapient.incomefinder.dao.impl.CityIncomeDAOFactory;
import com.sapient.incomefinder.exception.IncomeFinderApplicationException;
import com.sapient.incomefinder.model.AverageIncomeRecord;
import com.sapient.incomefinder.service.CityIncomeService;
import com.sapient.incomefinder.service.impl.CityIncomeServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class App.
 */
public class App {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		CityIncomeDao cityIncomeDao;
		CityIncomeService cityIncomeService;

		try {
			
			//String inputFileName = "C:\\Users\\indiahiring\\Desktop\\Vishnu\\input_coding_Exercise_PerCapitaIncome.csv";
			String inputFileName = args[0];
			int lastDot = inputFileName.lastIndexOf('.');
			String dataSourceName = inputFileName.substring(lastDot + 1);
			cityIncomeDao = CityIncomeDAOFactory
					.getCityIncomeDao(dataSourceName);
			cityIncomeService = new CityIncomeServiceImpl(cityIncomeDao);

			List<AverageIncomeRecord> averageIncomeRecords = cityIncomeService
					.getAverageIncomeByCity(inputFileName);

			//String outputFileName = "C:\\Users\\indiahiring\\Desktop\\Vishnu\\output.csv";
			String outputFileName = args[1];
			try (BufferedWriter writer = Files
					.newBufferedWriter(Paths
							.get(outputFileName));

					CSVPrinter csvPrinter = new CSVPrinter(writer,
							CSVFormat.DEFAULT.withHeader("City/Country",
									"Gender", "Average Income(in USD)"));) {

				for (AverageIncomeRecord averageIncomeRecord : averageIncomeRecords) {
					csvPrinter.printRecord(averageIncomeRecord.getPlace(),
							averageIncomeRecord.getGender(),
							averageIncomeRecord.getAverageIncome());
				}
				csvPrinter.flush();
			} catch (IOException e) {
				throw new IncomeFinderApplicationException("There is some problem with the application");
			}
		} catch (IncomeFinderApplicationException e1) {
			System.out.println(e1.getMessage());
		}

	}
}
