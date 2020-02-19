package dropRateCalculator;
import java.util.ArrayList;

/**
 * Class representing a creature, with its possible drops, that appears in a World of Warcraft gold farming route.
 * @author Tim Schommer
 *
 */
public class Creature 
{
	/**
	 * The position of the creature in a list of creatures in the route, indexing starts at 1.
	 */
	private int position;
	
	/**
	 * The name of the creature.
	 */
	private String name;
	
	/**
	 * The number of the creature that spawn in the farming route.
	 */
	private int numInRoute;
	
	/**
	 * The number of possible drops the creature has.
	 */
	private int dropNum;
	
	/**
	 * The list of the creature's possible drops.
	 */
	private ArrayList<Drop> drops;
	
	/**
	 * Constructs a creature with the given list position, number in the route, and name.
	 * @param pos
	 * 		Position of the creature in the list.
	 * @param num
	 * 		The number of the creature that spawn in the farming route.
	 * @param givenName
	 * 		The name of the creature.
	 */
	public Creature(int pos, int num, String givenName)
	{
		dropNum = 0;
		position = pos;
		numInRoute = num;
		name = givenName;
		drops = new ArrayList<>();
	}
	
	/**
	 * Constructs a creature with the given number in the route, name, and default position of 0.
	 * @param num
	 * 		The number of the creature that spawn in the farming route.
	 * @param givenName
	 * 		The name of the creature.
	 */
	public Creature(int num, String givenName)
	{
		dropNum = 0;
		position = 0;
		numInRoute = num;
		name = givenName;
		drops = new ArrayList<>();
	}
	
	/**
	 * Sets the name of the creature.
	 * @param givenName
	 * 		The name to change the creature name to.
	 */
	public void setName(String givenName)
	{
		name = givenName;
	}
	
	/**
	 * Gets the name of the creature.
	 * @return
	 * 		The name of the creature.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the position of the creature.
	 * @param place
	 * 		The new position to give the creature.
	 */
	public void setPosition(int place)
	{
		position = place;
	}
	
	/**
	 * Gets the position of the creature.
	 * @return
	 * 		The position of the creature.
	 */
	public int getPosition()
	{
		return position;
	}
        
	/**
	 * Gets the number of the creature that appear in the farming route.
	 * @return
	 * 		The number of the creature that appear in the farming route.
	 */
    public int getNumInRoute()
    {
        return numInRoute;
    }
    
    /**
     * Sets the number of the creature that appear in the farming route.
     * @param num
     * 		The new number of the creature that appear in the route.
     */
    public void setNumInRoute(int num)
    {
    	numInRoute = num;
    }
	
    /**
     * Adds a drop to the creature with the given name, value, and drop chance.
     * @param givenName
     * 		The name of the drop to be added.
     * @param val
     * 		The value of the drop to be added.
     * @param percentage
     * 		The drop chance of the drop to be added.
     */
	public void addDrop(String givenName, double val, double percentage)
	{
		dropNum += 1;
		drops.add(new Drop(givenName, val, percentage, dropNum));
	}
	
	/**
     * Adds a drop to the creature with the given value and drop chance and a default name.
     * @param givenName
     * 		The name of the drop to be added.
     * @param val
     * 		The value of the drop to be added.
     * @param percentage
     * 		The drop chance of the drop to be added.
     */
	public void addDrop(double val, double percentage)
	{
		dropNum += 1;
		String nm = "Drop_" + dropNum;
		drops.add(new Drop(nm, val, percentage, dropNum));
	}
	
	/**
	 * Remove the drop at the given position from the list of drops.
	 * @param posit
	 * 		The position (list index + 1) of the drop to be removed from the list.
	 */
	public void removeDrop(int posit)
	{
		drops.remove(posit - 1);
		dropNum -= 1;
		for(int index = 0; index < drops.size(); index++)
		{
			drops.get(index).setPosition(index + 1);
		}
	}
	
	/**
	 * Calculates the average amount of gold obtained from selling the creature's drops, per creature killed.
	 * @return
	 * 		The average amount of gold obtained from selling the creature's drops, per creature killed.
	 */
	public double avgGldPerKill()
	{
		double total = 0;
		for(Drop drop : drops)
		{
			total += drop.avgGldPerKill();
		}
		return total;
	}
	
	/**
	 * Calculates the average amount of gold obtained from selling the creature's drops, 
	 * per repetition of the farming route.
	 * @return
	 * 		The average amount of gold obtained from selling the creature's drops, per repetition of the farming route.
	 */
	public double avgGldPerRoute()
	{
		return avgGldPerKill() * numInRoute;
	}
	
	/**
	 * Returns the list of the creature's drops.
	 * @return
	 * 		The list of the creature's drops.
	 */
	public ArrayList<Drop> getDrops()
    {
        return drops;
    }
}
