/**
 * 
 */
package model;

/**
 * @author Bart Taelemans
 * @date 11 dec. 2017
 * @project Opdracht7
 * @purpose Class om omrekeningen van valuta te doen
 *
 */
public final class AmountAdapter implements IAmount
{
	private CurrencyRates currencyRates = CurrencyRates.getCurrencyRates();

	@Override
	public double getAmountForeign(Person person)
	{
		return person.getAmount() * currencyRates.getValue(person.getNationality().getCurrency());

	}

	@Override
	public double getAmountEuro(Person person)
	{
		return person.getAmount() / currencyRates.getValue(person.getNationality().getCurrency());
		
	}
	
	

}
