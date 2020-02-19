package probability;

import java.util.Comparator;

/**
 * Models a possible outcome of a random event.
 * @author Tim Schommer
 *
 */
public class Outcome
{
	/**
	 * The value associated with the event occurring. For instance if the event is winning a bet, the value would be the amount to be won.
	 */
	private double value;
	
	/**
	 * The chance of the event occurring.
	 */
	private double chance;
	
	/**
	 * Constructs an outcome with a value and a chance of occurring.
	 * @param val
	 * 		The value of the event.
	 * @param prob
	 * 		The chance of the event occurring.
	 */
	public Outcome(double val, double prob)
	{
		value = val;
		chance = prob;
	}
	
	/**
	 * Returns the value of the outcome.
	 * @return
	 * 		The value of the outcome.
	 */
	public double getValue()
	{
		return value;
	}
	
	/**
	 * Returns the chance of the outcome occurring.
	 * @return
	 * 		The chance of the outcome occurring.
	 */
	public double getChance()
	{
		return chance;
	}

}

/**
 * Comparator class allowing outcomes to be ordered by value.
 * @author Tim Schommer
 *
 */
class SortByValue implements Comparator<Outcome>
{
	@Override
	public int compare(Outcome first, Outcome other) 
	{
		if(first.getValue() < ((Outcome)other).getValue())
		{
			return -1;
		}
		else if(first.getValue() > ((Outcome)other).getValue())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
