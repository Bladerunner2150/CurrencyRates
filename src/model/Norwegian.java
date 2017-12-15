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
public class Norwegian extends Nationality
{
	public Norwegian()
	{
		super.setNationality("Norwegian");
		super.setLanguage("Norwegian");
		super.setCurrency("NOK");
	}
}
