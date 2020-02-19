package supplementalMath;

import java.math.BigInteger;

/**
 * Class holding a few math functions for use with probability functions.
 * @author Tim Schommer
 *
 */
public class SupplementalMath 
{
	/**
	 * Returns a BigInteger object holding the value <n> factorial.
	 * @param n
	 * 		The number to find the factorial of.
	 * @return
	 * 		BigInteger holding <n> factorial.
	 */
	public static BigInteger factorial(int n)
	{
		
		  BigInteger fact = new BigInteger("1");
		  for (int i = 1; i <= n; i++) 
		  {
		       fact = fact.multiply(new BigInteger(i + ""));
		  }
		  fact = new BigInteger(fact.toString());
		  return fact;
	}
	
	/**
	 * Calculates n Choose k.
	 * @param n
	 * 		The number of options to choose from.
	 * @param k
	 * 		The number of options to choose.
	 * @return
	 * 		The number of combinations for n Choose k.
	 */
	public static int nChooseK(int n, int k)
	{
		BigInteger numerator = factorial(n);
		BigInteger denom1 = factorial(k);
		BigInteger denom2 = factorial(n - k);
		BigInteger denom = new BigInteger(denom1.multiply(denom2).toString());
		BigInteger answer = new BigInteger(numerator.divide(denom).toString());
		return answer.intValue();
	}
	
}
