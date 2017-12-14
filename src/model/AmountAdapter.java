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
public final class AmountAdapter extends Nationality implements IAmount
{
	private CurrencyRates currencyRates = CurrencyRates.getCurrencyRates();

	@Override
	public Double getAmountForeign(Double amountEuro)
	{
		return amountEuro * currencyRates.getValue(getCurrency());

	}

	@Override
	public Double getAmountEuro(Double amountForeign)
	{
		return amountForeign / currencyRates.getValue(getCurrency());
		
	}
	
	

}
