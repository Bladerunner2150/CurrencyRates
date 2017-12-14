/**
 * 
 */
package model;

/**
 * @author Bart Taelemans
 * @date 4 dec. 2017
 * @project Opdracht7
 * @purpose Gegevens nationaliteit bijhouden (state pattern)
 *
 */
public class Nationality
{
	private String nationality;
	private String language;
	private String currency;

	/**
	 * @return the nationality
	 */
	public String getNationality()
	{
		return nationality;
	}

	/**
	 * @param nationality
	 *            the nationality to set
	 */
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}

	/**
	 * @return the language
	 */
	public String getLanguage()
	{
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getNationality() + ", Language = " + getLanguage()	+ ", Currency = " + getCurrency() + " ";
	}
	
	

}
