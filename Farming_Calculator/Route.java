package dropRateCalculator;
import java.util.ArrayList;

/**
 * Class representing a Farming route followed by World of Warcraft gold farmers.
 * @author Tim Schommer
 *
 */
public class Route 
{
	/**
	 * The number of different creatures that appear in the route.
	 */
	private int creatNum;
	
	/**
	 * A list of the different creatures that appear in the route.
	 */
	private ArrayList<Creature> creatures;
	
	/**
	 * Constructs a farming route with no creatures.
	 */
	public Route()
	{
		creatNum = 0;
		
		creatures = new ArrayList<>();
	}
	
	/**
	 * Adds a creature to the route with the given number in the route and the given name.
	 * @param num
	 * 		The number of the creature that will be in the route.
	 * @param name
	 * 		The name of the creature.
	 */
	public void addCreature(int num, String name)
	{
		creatNum += 1;
		creatures.add(new Creature(creatNum, num, name));
	}
	
	/**
	 * Adds a creature to the route with the given number in the route a default given name.
	 * @param num
	 * 		The number of the creature that will be in the route.
	 */
	public void addCreature(int num)
	{
		creatNum += 1;
		String name = "Creature_" + creatNum;
		creatures.add(new Creature(creatNum, num, name));
	}
	
	/**
	 * Removes the creature stored at the given position (position = index + 1) from the list.
	 * @param posit
	 * 		The position of the creature in the list.
	 */
	public void removeCreature(int posit)
	{
		creatures.remove(posit - 1);
		creatNum -= 1;
		for(int index = 0; index < creatures.size(); index++)
		{
			creatures.get(index).setPosition(index + 1);
		}
	}
	
	/**
	 * Adds a drop to the creature at the given position using the given name, drop value, and drop chance.
	 * @param creatPos
	 * 		The position of the creature to add the drop to.
	 * @param givenName
	 * 		The name of the drop to be added.
	 * @param val
	 * 		The gold value of the drop to be added.
	 * @param percentage
	 * 		The drop chance of the item to be added.
	 */
	public void addDrop(int creatPos, String givenName, double val, double percentage)
	{
		creatures.get(creatPos - 1).addDrop(givenName, val, percentage);
	}
	
	/**
	 * Adds a drop to the creature at the given position using the given drop value and drop chance and a default name.
	 * @param creatPos
	 * 		The position of the creature to add the drop to.
	 * @param val
	 * 		The gold value of the drop to be added.
	 * @param percentage
	 * 		The drop chance of the item to be added.
	 */
	public void addDrop(int creatPos, double val, double percentage)
	{
		creatures.get(creatPos - 1).addDrop(val, percentage);
	}
	
	/**
	 * Removes the drop stored at the second position from the creature stored at the first position. 
	 * @param creatPos
	 * 		The position of the creature to remove the drop from.
	 * @param dropPosit
	 * 		The position of the drop to be removed.
	 */
	public void removeDrop(int creatPos, int dropPosit)
	{
		creatures.get(creatPos - 1).removeDrop(dropPosit);
	}
	
	/**
	 * Calculates the average amount of gold obtained from selling the drops obtained 
	 * per repetition of the farming route.
	 * @return
	 * 		The average amount of gold obtained from selling the drops obtained per repetition of the farming route.
	 */
	public double avgGldPerRoute()
	{
		double total = 0;
		for(Creature creat : creatures)
		{
			total += creat.avgGldPerRoute();
		}
		return total;
	}
	
	/**
	 * Calculates the average amount of gold obtained from selling the drops obtained in the route, 
	 * in the given amount of time.
	 * @param time
	 * 		The timeframe to calculate the gold return from.
	 * @return
	 * 		The average amount of gold obtained from selling the drops obtained in the route, 
	 * 		in the given amount of time.
	 */
	public double gldPerTime(double time)
	{
		return avgGldPerRoute() / time;
	}
	
	/**
	 * Returns the list of creatures in the route.
	 * @return
	 * 		The list of creatures in the route.
	 */
    public ArrayList<Creature> getCreatures()
    {
        return creatures;
    }
	
	
}
