/**
 * 
 */
package model;

/**
 * @author Bart Taelemans
 * @date 11 dec. 2017
 * @project Opdracht7
 * @purpose interface voor class AmountAdapter
 *
 */
public interface IAmount
{
	void getAmountForeign(Double amountEuro);
	void getAmountEuro(Double amountForeign);

}
