/**
 * 
 */
package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Random;

import model.AmountAdapter;
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
	private static AmountAdapter adapter = new AmountAdapter();
	private static LinkedList<Person> persons;
	private static LinkedList<Person> personsInEur;
	private static LinkedList<Person> personsInOwnCurrency;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO method to change person to new nationality
		
		persons = generatePersonlist();	
		personsInEur = generatePersonlistInEur(persons);	
		personsInOwnCurrency = revertBackToOwnCurrency(personsInEur);
		System.out.println("Generated list:" + System.lineSeparator() + persons);	
		System.out.println("List of people with conversion to EUR:" + System.lineSeparator() + personsInEur);
		System.out.println("List of people back to own Currency:" + System.lineSeparator() + personsInOwnCurrency);
	}
	
	
	//generate list with Persons
	public static LinkedList<Person> generatePersonlist(){
		LinkedList<Person> personList= new LinkedList<Person>();
		for (int i = 0; i < 10; i++) {
			personList.add(generatePerson());
		}
		return personList;
	}
	
	//generate list with Persons but currency set in EUR + amount = EUR equivalent
	public static LinkedList<Person> generatePersonlistInEur(LinkedList<Person> pl){
		LinkedList<Person> personList= new LinkedList<Person>();
		Person p;
		for (Person person : pl) {
			p = PersonFactory.CreatePerson((person.getNationality().getNationality()), getCurrencyEuro(person));// keep nationality but change amount to euro equivalent
			p.getNationality().setCurrency("EUR");// set currency to eur
			personList.add(p);
		}
		return personList;
	}
	//generate list with Persons where currency and amount is reverted back to own currency
	public static LinkedList<Person> revertBackToOwnCurrency(LinkedList<Person> pl){
		LinkedList<Person> personList= new LinkedList<Person>();
		Person p;
		for (Person person : pl) {
			p = PersonFactory.CreatePerson((person.getNationality().getNationality()), person.getAmount());// "reset" nationality and currency to original and fill in eur amount
			p.setAmount(getOwnCurrency(p)); // change eur amount to own currency
			personList.add(p);
		}
		return personList;
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
	
	//Convert person's amount to Euro
	public static double getCurrencyEuro (Person p) {
		return adapter.getAmountEuro(p);
	}
	//Convert euro amount back to person's own currency
	public static double getOwnCurrency (Person p) {
		return adapter.getAmountForeign(p);
	}

}
