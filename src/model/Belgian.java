/**
 * 
 */
package model;

/**
 * @author: Jeroen Salaets en Bart Taelemans
 * @date: 13 dec. 2017
 * @Project: Opdracht7
 * @Purpose: State in state pattern
 */
public class Belgian extends Nationality
{

	public Belgian()
	{
		super.setNationality("Belgian");
		super.setLanguage("Dutch");
		super.setCurrency("EUR");
	}
}
