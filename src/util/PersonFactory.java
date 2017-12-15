/**
 * 
 */
package util;

import model.Nationality;
import model.Person;

/**
 * @author Bart Taelemans
 * @date 4 dec. 2017
 * @project Opdracht7
 * @purpose Personen aanmaken
 *
 */
public class PersonFactory
{
	public static Person CreatePerson (Nationality nat, double amt) {
		Person person = new Person(nat, amt);
		return person;
	}
}
