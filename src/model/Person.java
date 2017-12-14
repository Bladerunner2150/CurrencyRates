/**
 * 
 */
package model;

/**
 * @author Bart Taelemans
 * @date 4 dec. 2017
 * @project Opdracht7
 * @purpose Gegevens persoon bijhouden
 *
 */
public class Person
{
	private Nationality nationality;
	private double amount;

	
	public Person(Nationality nat, double amt) {
		this.setNationality(nat);
		this.setAmount(amt);
	}
	/**
	 * @return the nationality
	 */
	public Nationality getNationality()
	{
		return nationality;
	}

	/**
	 * @param nationality
	 *            the nationality to set
	 */
	public void setNationality(Nationality nationality)
	{
		this.nationality = nationality;
	}

	/**
	 * @return the amount
	 */
	public double getAmount()
	{
		return amount; // hier conversie doen (via adapter/muntconversie) van euro naar originele
						// currency (amount staat al in euro door setter)
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount)
	{
		this.amount = amount; // hier conversie doen van originele currency van persoon naar euro
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Person: nationality = " + getNationality().toString() + getAmount();
	}

}
