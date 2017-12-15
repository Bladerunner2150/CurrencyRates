/**
 * 
 */
package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Bart Taelemans en Jeroen Salaets
 * @date 4 dec. 2017
 * @project Opdracht7
 * @purpose Properties van munteenheden ophalen voor conversie (singleton
 *          pattern)
 *
 */
public class CurrencyRates
{
	private static CurrencyRates currencyRates = null;
	private Properties props;

	protected CurrencyRates() throws IOException
	{
		props = new Properties();
		props.load(new FileInputStream("src/rates.properties"));
	}

	public static CurrencyRates getCurrencyRates()
	{
		if (currencyRates == null)
		{
			try
			{
				currencyRates = new CurrencyRates();
			} catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		return currencyRates;
	}

	public double getValue(String key)
	{
		return Double.parseDouble(props.getProperty(key));
	}

}
