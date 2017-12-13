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
	private Amount amount;

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
	public Amount getAmount()
	{
		return amount; // hier conversie doen (via adapter/muntconversie) van euro naar originele
						// currency (amount staat al in euro door setter)
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Amount amount)
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
		return "Person [nationality=" + nationality + ", amount=" + amount + "]";
	}

}
