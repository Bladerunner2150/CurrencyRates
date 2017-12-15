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
public class British extends Nationality
{

	public British()
	{
		super.setNationality("British");
		super.setLanguage("English");
		super.setCurrency("GBP");
	}
}
