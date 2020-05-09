package com.sapient.incomefinder.model;


// TODO: Auto-generated Javadoc
/**
 * The Class CityIncome.
 */
public class CityIncome {

	/** The id. */
	private int id;
	
	/** The city. */
	private City city;
	
	/** The gender. */
	private String gender;
	
	/** The currency. */
	private String currency;
	
	/** The average income. */
	private float averageIncome;

	/**
	 * Instantiates a new city income.
	 */
	public CityIncome() {
	}

	/**
	 * Instantiates a new city income.
	 *
	 * @param city the city
	 * @param gender the gender
	 * @param currency the currency
	 * @param averageIncome the average income
	 */
	public CityIncome(City city, String gender, String currency,
			float averageIncome) {
		this.city = city;
		this.gender = gender;
		this.currency = currency;
		this.averageIncome = averageIncome;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the average income.
	 *
	 * @return the average income
	 */
	public float getAverageIncome() {
		return averageIncome;
	}

	/**
	 * Sets the average income.
	 *
	 * @param averageIncome the new average income
	 */
	public void setAverageIncome(Float averageIncome) {
		this.averageIncome = averageIncome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CityIncome [id=" + id + ", city=" + city + ", gender=" + gender
				+ ", currency=" + currency + ", averageIncome=" + averageIncome
				+ "]";
	}

}
