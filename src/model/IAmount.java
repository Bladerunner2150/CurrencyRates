/**
 * 
 */
package model;

/**
 * @author Bart Taelemans en Jeroen Salaets
 * @date 11 dec. 2017
 * @project Opdracht7
 * @purpose interface voor class AmountAdapter
 *
 */
public interface IAmount
{
	double getAmountForeign(Person person);

	double getAmountEuro(Person person);

}
