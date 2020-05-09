package com.sapient.incomefinder.model;

// TODO: Auto-generated Javadoc
/**
 * The Class AverageIncomeRecord.
 */
public class AverageIncomeRecord implements Comparable {

	/** The place. */
	private String place;

	/** The gender. */
	private String gender;

	/** The average income. */
	private float averageIncome;

	/** The total salary. */
	private float totalSalary;

	/** The count. */
	private int count = 0;

	/**
	 * Instantiates a new average income record.
	 */
	public AverageIncomeRecord() {
	}

	/**
	 * Instantiates a new average income record.
	 *
	 * @param place
	 *            the place
	 * @param gender
	 *            the gender
	 * @param totalSalary
	 *            the total salary
	 */
	public AverageIncomeRecord(String place, String gender, float totalSalary) {
		super();
		this.place = place;
		this.gender = gender;
		this.totalSalary = totalSalary;
	}

	/**
	 * Gets the place.
	 *
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Sets the place.
	 *
	 * @param place
	 *            the new place
	 */
	public void setPlace(String place) {
		this.place = place;
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
	 * @param gender
	 *            the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * @param averageIncome
	 *            the new average income
	 */
	public void setAverageIncome(float averageIncome) {
		this.averageIncome = averageIncome;
	}

	/**
	 * Gets the total salary.
	 *
	 * @return the total salary
	 */
	public float getTotalSalary() {
		return totalSalary;
	}

	/**
	 * Sets the total salary.
	 *
	 * @param f
	 *            the new total salary
	 */
	public void setTotalSalary(float f) {
		this.totalSalary = f;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count
	 *            the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AverageIncome [place=" + place + ", gender=" + gender
				+ ", averageIncome=" + averageIncome + "]\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AverageIncomeRecord other = (AverageIncomeRecord) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof AverageIncomeRecord) {
			AverageIncomeRecord tmp = (AverageIncomeRecord) obj;
			if (this.place.compareTo(tmp.getPlace()) == 0) {
				if (this.gender.compareTo(tmp.getGender()) == 0) {
					if (this.averageIncome == tmp.getAverageIncome()) {
						return 0;
					} else if (this.averageIncome == tmp.getAverageIncome()) {
						return -1;
					} else {
						return 1;
					}
				} else {
					this.gender.compareTo(tmp.getGender());
				}
			} else {
				return this.place.compareTo(tmp.getPlace());
			}
		}
		return 0;
	}
}
