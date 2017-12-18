/**
 * 
 */
package model;

/**
 * @author Bart Taelemans en Jeroen Salaets
 * @date 4 dec. 2017
 * @project Opdracht7
 * @purpose Gegevens persoon bijhouden
 *
 */
public class Person
{
	private Nationality nationality;
	private double amount;
	IAmount adapter = new AmountAdapter();

	public Person(Nationality nat, double amt)
	{
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
		return adapter.getAmountForeign(amount, nationality); // hier conversie doen (via adapter/muntconversie) van euro naar originele
						// currency (amount staat al in euro door setter)
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amt)
	{
		this.amount = adapter.getAmountEuro(amt, getNationality()); // hier conversie doen van originele currency van persoon naar euro
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Person: Nationality = " + getNationality().toString() + String.format("%.2f", getAmount())
				+ System.lineSeparator();
	}

}
