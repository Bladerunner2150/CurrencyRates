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
public class American extends Nationality
{

	public American()
	{
		super.setNationality("American");
		super.setLanguage("English");
		super.setCurrency("USD");
	}
}
