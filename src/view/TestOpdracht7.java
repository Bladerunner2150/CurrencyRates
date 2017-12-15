/**
 * 
 */
package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Random;

import model.American;
import model.AmountAdapter;
import model.Belgian;
import model.British;
import model.Nationality;
import model.Norwegian;
import model.Person;
import model.Swedish;
import model.Swiss;
import util.PersonFactory;

/**
 * @author Bart Taelemans en Jeroen Salaets
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
	private static LinkedList<Person> listToShow;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		persons = generatePersonlist(); // generate list of random persons
		System.out.println("Generated list:" + System.lineSeparator() + persons);
		listToShow = generatePersonlistInEur(persons);// switch current amount in own currency to eur equivalent
		System.out.println("List of people with conversion to EUR:" + System.lineSeparator() + listToShow);
		listToShow = revertBackToOwnCurrency(listToShow);// switch back to own currency and equivalent amount
		System.out.println("List of people back to own Currency:" + System.lineSeparator() + listToShow);
		listToShow = switchNationality(persons);// make a random person switch nationality and adapt amount to new
												// currency
		System.out.println("\n List with one person who changed nationality:" + System.lineSeparator() + listToShow);
	}

	// generate list with Persons
	public static LinkedList<Person> generatePersonlist()
	{
		LinkedList<Person> personList = new LinkedList<Person>();
		for (int i = 0; i < 10; i++)
		{
			personList.add(generatePerson());
		}
		return personList;
	}

	// generate list with Persons but currency set in EUR + amount = EUR equivalent
	public static LinkedList<Person> generatePersonlistInEur(LinkedList<Person> pl)
	{
		for (Person person : pl)
		{
			person.setAmount(getCurrencyEuro(person));
			person.getNationality().setCurrency("EUR");// set currency to eur
		}
		return pl;
	}

	// generate list with Persons where currency and amount is reverted back to own
	// currency
	public static LinkedList<Person> revertBackToOwnCurrency(LinkedList<Person> pl)
	{
		for (Person person : pl)
		{
			person.setNationality(getNationality(person.getNationality().getNationality()));// "reset" nationality and
																							// currency to original
			person.setAmount(getOwnCurrency(person)); // change eur amount to own currency
		}
		return pl;
	}

	// switch nationality for random person in list
	public static LinkedList<Person> switchNationality(LinkedList<Person> pl)
	{
		int index = random.nextInt(pl.size());
		Person person2 = pl.get(index);// get random person from list
		person2.setAmount(getCurrencyEuro(person2));// first conversion to eur before conversion to new currency
		person2.setNationality(getNationality(getCountry()));// set nationality of person to new nationality
		person2.setAmount(getOwnCurrency(person2));// conversion of amount in eur to new currency
		pl.set(index, person2);
		return pl;
	}

	// generate random person
	public static Person generatePerson()
	{
		Person person = PersonFactory.CreatePerson(getNationality(getCountry()), round(returnRandomDouble(0, 100), 2));
		return person;
	}

	// generate random nationalityString
	public static String getCountry()
	{
		String nationalities[] =
		{ "American", "Belgian", "British", "Norwegian", "Swedish", "Swiss" };
		return nationalities[random.nextInt(nationalities.length)];
	}

	// generate nationality
	public static Nationality getNationality(String country)
	{

		Nationality nationality;

		switch (country)
		{
		case "American":
			nationality = new American();
			break;
		case "Belgian":
			nationality = new Belgian();
			break;
		case "British":
			nationality = new British();
			break;
		case "Norwegian":
			nationality = new Norwegian();
			break;
		case "Swedish":
			nationality = new Swedish();
			break;
		case "Swiss":
			nationality = new Swiss();
			break;
		default:
			nationality = null;
			break;
		}
		return nationality;
	}

	// generate random amount
	public static double returnRandomDouble(int min, int max)
	{
		double range = max - min;
		double scaled = random.nextDouble() * range;
		double shifted = scaled + min;
		return shifted; // == (rand.nextDouble() * (max-min)) + min;
	}

	// round numbers to 2 digits
	private static double round(double value, int places)
	{
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	// Convert person's amount to Euro
	public static double getCurrencyEuro(Person p)
	{
		return adapter.getAmountEuro(p);
	}

	// Convert euro amount back to person's own currency
	public static double getOwnCurrency(Person p)
	{
		return adapter.getAmountForeign(p);
	}

}
