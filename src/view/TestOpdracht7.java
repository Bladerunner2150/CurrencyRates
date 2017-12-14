/**
 * 
 */
package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Random;

import model.Person;
import util.PersonFactory;

/**
 * @author Bart Taelemans
 * @date 4 dec. 2017
 * @project Opdracht7
 * @purpose Opdracht 7 uitvoeren
 *
 */
public class TestOpdracht7
{
	private static Random random = new Random();
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO method to show person with own currency
		// TODO method to show person with currency in EUR
		// TODO method to change person to new nationality
		
		LinkedList<Person> persons = new LinkedList<Person>();
		
		for (int i = 0; i < 10; i++) {
			persons.add(generatePerson());
		}
		
		for (Person person : persons) {
			System.out.println(person.toString());
		}
		
	}
	
	//generate random person
	public static Person generatePerson() {
		Person person = PersonFactory.CreatePerson(getNationality(), round(returnRandomDouble(0, 100),2));
		return person;
	}
	//generate random nationality
	public static String getNationality() {
		String nationalities[] = { "American","Belgian", "British", "Norwegian", "Swedish", "Swiss"};
		return nationalities[random.nextInt(nationalities.length)];
	}
	//generate random amount
	public static double returnRandomDouble(int min, int max) {
		double range = max - min;
		double scaled = random.nextDouble() * range;
		double shifted = scaled + min;
		return shifted; // == (rand.nextDouble() * (max-min)) + min;
	}
	//round numbers to 2 digits
	private static double round (double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
