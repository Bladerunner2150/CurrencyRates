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
public class Swedish extends Nationality
{

	public Swedish()
	{
		super.setNationality("Swedish");
		super.setLanguage("Swedish");
		super.setCurrency("SEK");
	}
}
