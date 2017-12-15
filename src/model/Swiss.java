/**
 * 
 */
package model;

/**
 * @author Bart Taelemans en Jeroen Salaets
 * @date 13 dec. 2017
 * @project CurrencyRates
 * @purpose State in state pattern
 *
 */
public class Swiss extends Nationality
{
	public Swiss()
	{
		super.setNationality("Swiss");
		super.setLanguage("German");
		super.setCurrency("CHF");
	}
}
