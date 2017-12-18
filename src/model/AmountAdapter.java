/**
 * 
 */
package model;

/**
 * @author Bart Taelemans en Jeroen Salaets
 * @date 11 dec. 2017
 * @project Opdracht7
 * @purpose Class om omrekeningen van valuta te doen
 *
 */
public final class AmountAdapter implements IAmount
{
	private CurrencyRates currencyRates = CurrencyRates.getCurrencyRates();

	@Override
	public double getAmountForeign(double amount, Nationality nationality)
	{
		return amount * currencyRates.getValue(nationality.getCurrency());

	}

	@Override
	public double getAmountEuro(double amount, Nationality nationality)
	{
		return amount / currencyRates.getValue(nationality.getCurrency());

	}

}
