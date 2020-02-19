package probability;


/**
 * Represents a Geometric Distribution.
 * @author Tim Schommer
 *
 */
public class Geometric extends DiscreteDistribution 
{
	/**
	 * The chance of the first of the two possible outcomes occurring.
	 */
	double probability;
	
	/**
	 * Constructs a Geometric Distribution with the given probability of the first event occurring.
	 * @param chance
	 * 		The probability of the first of the two possible outcomes occurring.
	 */
	public Geometric(double chance)
	{
		probability = chance;
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
		
		return "Geometric distribution with probability: " + probability;
	}

	@Override
	public double expectedValue() 
	{
		return 1.0 / probability;
	}

	@Override
	public double variance() 
	{
		return (1.0 - probability) / (Math.pow(probability, 2));
	}


	@Override
	public double pdf(double value) 
	{
		return (Math.pow((1 - probability), (value - 1)) * probability);
	}

	@Override
	public double cdf(double value) 
	{
		return (1 - Math.pow((1 - probability), value));		
	}

	
}
