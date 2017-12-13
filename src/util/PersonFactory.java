/**
 * 
 */
package util;


import model.American;
import model.Belgian;
import model.British;
import model.Nationality;
import model.Person;
import model.Swedish;

/**
 * @author Bart Taelemans
 * @date 4 dec. 2017
 * @project Opdracht7
 * @purpose Personen aanmaken
 *
 */
public class PersonFactory
{
	public static Person CreatePerson (String nat, double amt) {
		Nationality nationality;
		Person person;
		switch (nat) {
		case "Belgian":
			nationality = new Belgian();
			person = new Person(nationality, 120.00);
			break;
		case "British":
			nationality = new British();
			person = new Person(nationality, 120.00);
			break;
		case "American":
			nationality = new American();
			person = new Person(nationality, 120.00);
			break;
		case "Swedish":
			nationality = new Swedish();
			person = new Person(nationality, 120.00);
			break;
		default:
			person = null;
			break;
		}
		return person;
	}
}
