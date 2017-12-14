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
public class AmountAdapter extends Nationality implements IAmount
{
	private CurrencyRates currencyRates = CurrencyRates.getCurrencyRates();

	@Override
	public void getAmountForeign(Double amountEuro)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void getAmountEuro(Double amountForeign)
	{
		// TODO Auto-generated method stub
		
	}
	
	

}
