package probability;

/**
 * An interface for calling on a probability distribution.
 * @author Tim Schommer
 *
 */
public interface Distribution 
{
	/**
	 * Returns the expected, or average, value taken on by the distribution
	 * @return
	 * 		Average value of the distribution
	 */
	public double expectedValue();
	
	/**
	 * Returns the amount by which the value varies from the average.
	 * @return
	 * 		The amount by which the value varies from the average
	 */
	public double variance();
	
	/**
	 * Another measure for the spread of values from the average. The square of the Variance.
	 * @return
	 * 		The standard deviation of the distribution.
	 */
	public double standardDeviation();
	
	/**
	 * The probability of the value occurring.
	 * @param value
	 * 		The value to determine the probability of.
	 * @return
	 * 		The probability of the value occurring.
	 */
	public double pdf(double value);
	
	/**
	 * The probability of the a value less than or equal to the chosen value occurring.
	 * @param value
	 * 		The value to find the probability of an occurrence of less than or equal to this value.
	 * @return
	 * 		The probability of a value less than or equal to the given value.
	 */
	public double cdf(double value);
	
	/**
	 * The probability of the a value less than to the chosen value occurring.
	 * @param value
	 * 		The value to find the probability of an occurrence of less than this value.
	 * @return
	 * 		The probability of a value less than to the given value.
	 */
	public double lessThan(double value);
	
	/**
	 * The probability of the a value greater than or equal to the chosen value occurring.
	 * @param value
	 * 		The value to find the probability of an occurrence of greater than or equal to this value.
	 * @return
	 * 		The probability of a value greater than or equal to the given value.
	 */
	public double greaterOrEqual(double value);
	
	/**
	 * The probability of the a value greater than the chosen value occurring.
	 * @param value
	 * 		The value to find the probability of an occurrence of greater than this value.
	 * @return
	 * 		The probability of a value greater than the given value.
	 */
	public double greaterThan(double value);
	
	
}
