package dropRateCalculator;
import probability.Geometric;
import probability.Binomial;
import probability.DiscreteDistribution;

/**
 * Class representing a possible item dropped from an enemy during World of Warcraft gold farming.
 * Also tracks its position in a list of drops.
 * @author Tim Schommer
 *
 */
public class Drop 
{
	/**
	 * Position of the drop in a list of drops, indexing starts at 1.
	 */
	private int position;
	
	/**
	 * The name of the drop.
	 */
	private String name;
	
	/**
	 * The chance of the item being dropped.
	 */
	private double rate;
	
	/**
	 * The value at which the item can be sold.
	 */
	private double value;
	
	/**
	 * Constructs a Drop with a name, value, drop chance, and position.
	 * @param givenName
	 * 		The name of the drop.
	 * @param val
	 * 		The gold value of the drop.
	 * @param percentage
	 * 		The chance of the item being dropped.
	 * @param place
	 * 		The position of the drop in the list.
	 */
	public Drop(String givenName, double val, double percentage, int place)
	{
		position = place;
		name = givenName;
		value = val;
		rate = percentage;
	}
	
	/**
	 * Constructs a Drop with a name, value, drop chance, and default position of 0.
	 * @param givenName
	 * 		The name of the drop.
	 * @param val
	 * 		The gold value of the drop.
	 * @param percentage
	 * 		The chance of the item being dropped.
	 */
	public Drop(String givenName, double val, double percentage)
	{
		position = 0;
		name = givenName;
		value = val;
		rate = percentage;
	}
	
	/**
	 * Sets the name of the drop.
	 * @param givenName
	 * 		The name to change the drop name to.
	 */
	public void setName(String givenName)
	{
		name = givenName;
	}
	
	/**
	 * Gets the name of the drop.
	 * @return
	 * 		The name of the drop.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the position of the drop.
	 * @param place
	 * 		The new position to give the drop.
	 */
	public void setPosition(int place)
	{
		position = place;
	}
	
	/**
	 * Gets the position of the drop.
	 * @return
	 * 		The position of the drop.
	 */
	public int getPosition()
	{
		return position;
	}
	
	/**
	 * Sets the drop chance of the item.
	 * @param percent
	 * 		The new drop chance of the item.
	 */
	public void setRate(double percent)
	{
		rate = percent;
	}
	
	/**
	 * Gets the drop chance of the item.
	 * @return
	 * 		The drop chance of the item.
	 */
	public double getRate()
	{
		return rate;
	}
	
	/**
	 * Sets the gold value of the drop.
	 * @param val
	 * 		The new gold value of the drop.
	 */
	public void setValue(double val)
	{
		value = val;
	}
	
	/**
	 * Gets the gold value of the drop.
	 * @return
	 * 		The gold value of the drop.
	 */
	public double getVal()
	{
		return value;
	}
	
	/**
	 * Calculates the average number of creatures a player would need to kill before they get a drop, 
	 * at the stored drop rate.
	 * @return
	 * 		The average number of creatures to kill in order to get the item to drop.
	 */
	public double avgKillsTillDrop()
	{
		Geometric geo = new Geometric(rate);
		return geo.expectedValue();
	}
	
	/**
	 * Calculates the average number of times a player would need to complete a farming route 
	 * before they got the given drop.
	 * @param creatPerRoute
	 * 		The number of the creatures which drop the item that appear in the farming route.
	 * @return
	 * 		The average number of times a player would need to complete a farming route before the item drops for them.
	 */
	public double avgRepsTillDrop(int creatPerRoute)
	{
		return avgKillsTillDrop() / creatPerRoute;
	}
	
	/**
	 * Calculates the average amount of time a player will need to spend farming before the item drops for them.
	 * @param time
	 * 		The amount of time each repetition of the route takes.
	 * @param creatPerRoute
	 * 		The number of the creatures which drop the item that appear in the farming route.
	 * @return
	 * 		The average amount of time a player would need to spend farming before the item drops for them.
	 */
	public double timeTillDrop(double time, int creatPerRoute)
	{
		return avgRepsTillDrop(creatPerRoute) * time;
	}
	
	/**
	 * Calculates the average amount of gold obtained per creature killed, from selling this drop.
	 * @return
	 * 		The average amount of gold obtained per creature killed, from selling this drop.
	 */
	public double avgGldPerKill()
	{
		DiscreteDistribution disc = new DiscreteDistribution();
		disc.addOutcome(0, 1 - rate);
		disc.addOutcome(value, rate);
		return disc.expectedValue();
	}
	
	/**
	 * Calculates the average number of times the item will drop in a given number of kills.
	 * @param trials
	 * 		The number of creature kills to calculate the number of drops from.
	 * @return
	 * 		The average number of times the item will drop in the given number of kills.
	 */
	public double avgDropsInNTrials(int trials)
	{
		Binomial bin = new Binomial(trials, rate);
		return bin.expectedValue();
	}
	
	/**
	 * Calculates the average number of times the item will drop when farming for a given timeframe.
	 * @param creatInRoute
	 * 		The number of creatures which drop the item within the farming route.
	 * @param time
	 * 		The amount of time it takes to do a repetition of the farming route.
	 * @param timeFrame
	 * 		The amount of time spent farming.
	 * @return
	 * 		The average number of times the item will drop when farming for a given timeframe.
	 */
	public double avgDropsPerTime(int creatInRoute, double time, double timeFrame)
	{
		return avgDropsInNTrials(creatInRoute) * timeFrame / time;
	}
	
	
}
