package probability;

import supplementalMath.SupplementalMath;

/**
 * Represents a Binomial Distribution.
 * @author Tim Schommer
 *
 */
public class Binomial extends DiscreteDistribution 
{
	/**
	 * The number of trials to occur.
	 */
	private int trials;
	/**
	 * The chance of the first of the two outcomes occurring.
	 */
	private double chance;
	
	/**
	 * Constructs a Binomial Distribution with the given number of trials 
	 * and the probability of the first outcome occurring.
	 * @param nTrials
	 * 		The number of times the "test" that creates the outcome will occur.
	 * @param probability
	 * 		The probability of the first outcome occurring.
	 */
	public Binomial(int nTrials, double probability)
	{
		trials = nTrials;
		chance = probability;
	}
	
	
	
	@Override
	public void addOutcome(double value, double probability)
	{
		//While it is technically a Discrete distribution, 
		//the ability to add outcomes has been removed due to there only being two possible outcomes.
	}
	
	@Override
	public void removeOutcome(int index)
	{
		//While it is technically a Discrete distribution, 
		//the ability to remove outcomes has been removed due to there only being two possible outcomes.
	}
	
	@Override
	public String toString()
	{
		
		return "Binomial distribution with " + trials +" trials and probability: " + chance;
	}

	@Override
	public double expectedValue() 
	{
		return trials * chance;
	}

	@Override
	public double variance() 
	{
		return trials * chance * (1 - chance);
	}

	
	public double pdf(int value) 
	{
		return SupplementalMath.nChooseK(trials, value) * Math.pow(chance, value) * Math.pow((1- chance), (trials - value));
	}

	public double cdf(int value) 
	{
		double total = 0;
		for(int i = 0; i <= value; i++)
		{
			total += pdf(value);
		}
		return total;	
	}
}
