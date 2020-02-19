package probability;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class representing a discrete probability distribution.
 * @author Tim Schommer
 *
 */
public class DiscreteDistribution implements Distribution 
{
	/**
	 * List of possible outcomes in a discrete distribution.
	 */
	private ArrayList<Outcome> outcomes;
	
	/**
	 * Basic constructor for a discrete distribution. Constructs with an empty list of outcomes.
	 */
	public DiscreteDistribution()
	{
		outcomes = new ArrayList<>();
	}
	
	/**
	 * Adds an outcome to the list of outcomes and places it in its sorted position.
	 * @param value
	 * 		The value of the outcome if it were to occur.
	 * @param probability
	 * 		The chance of the outcome occurring.
	 */
	public void addOutcome(double value, double probability)
	{
		outcomes.add(new Outcome(value, probability));
		
		Collections.sort(outcomes, new SortByValue());
	}
	
	/**
	 * Removes the outcome stored at the given index.
	 * @param index
	 * 		The index of the outcome to remove.
	 */
	public void removeOutcome(int index)
	{
		if(index >= 0 && index < outcomes.size())
		{
			outcomes.remove(index);
		}
	}
	
	@Override
	public String toString()
	{
		String output = "";
		
		for(int index = 0; index < outcomes.size(); index++)
		{
				output += index + ") value: " + outcomes.get(index).getValue() + " probability: " + outcomes.get(index).getChance() + "\n";
		}
		return output;
	}

	@Override
	public double expectedValue() 
	{
		double expected = 0;
		for(Outcome outcome : outcomes)
		{
			//The expected value of an individual outcome is the value of the outcome multiplied by the chance of it occurring.
			//The expected value of the discrete distribution is the sum of the expected values for each outcome.
			expected += outcome.getValue() * outcome.getChance();
		}
		return expected;
	}

	@Override
	public double variance() 
	{
		double expected = 0;
		for(Outcome outcome : outcomes)
		{
			expected += Math.pow(outcome.getValue(), 2) * outcome.getChance();
		}
		return expected - Math.pow(expectedValue(), 2);
	}

	@Override
	public double standardDeviation() 
	{
		return Math.sqrt(variance());
	}

	@Override
	public double pdf(double value) 
	{
		for(int index = 0; index < outcomes.size(); index++)
		{
			if(outcomes.get(index).getValue() == value)
			{
				return outcomes.get(index).getChance();
			}
		}
		return 0;
	}

	@Override
	public double cdf(double value) 
	{
		if(value < outcomes.get(0).getValue())
		{
			return 0;
		}
		else if(value >= outcomes.get(outcomes.size() - 1).getValue())
		{
			return 1;
		}
		else
		{
			int start = 0;
			for(int index = 0; index < outcomes.size(); index++)
			{
				if(value == outcomes.get(index).getValue())
				{
					start = index;
				}
				else if((value < outcomes.get(index).getValue()) && (value > outcomes.get(index - 1).getValue()))
				{
					start = index - 1;
				}
			}
			
			double ret = 0;
			for(int index = start; index >= 0; index--)
			{
				ret += outcomes.get(index).getChance();
			}
			
			return ret;
		}
		
	}

	@Override
	public double lessThan(double value) {
		return cdf(value) - pdf(value);
	}

	@Override
	public double greaterOrEqual(double value) {
		return 1 - lessThan(value);
	}

	@Override
	public double greaterThan(double value) {
		return 1 - cdf(value);
	}

}
