
import java.io.*;
import java.util.*;

public class Player extends Entity
{
	float health = 1.0F;
	float brain = 1.0F;
	float feed = 0.90F;
	
	List<Modifier> modifiers = new ArrayList<Modifier>();
	
	public Player(Game game)
	{
		super(game);
		printStat("");
	}
	
	public void update()
	{
		String modifierNames = getModifiers();
		for (int i = 0; i < modifiers.size(); i++)
		{
			modifiers.get(i).update();
		}
		printStat(modifierNames);
		if (health <= 0)
		{
			die();
		}
	}
	
	public void printStat(String modifierNames)
	{
		
		System.out.print("h: " + (int) ( getHealth() * 100) + " " + 
							"f: " + (int) ( getFeed() * 100) + " " +
							"b: " + (int) ( getBrain() * 100));
		System.out.print(modifierNames);
		System.out.println();
	}

	private String getModifiers()
	{
		String modifierNames = "";
		if (!modifiers.isEmpty())
		{
			for (Modifier m : modifiers) { modifierNames += ", " + m.getName();}
		}
		return modifierNames;
	}
	
	public static float toProcent(float amount)
	{
		return amount / 100.0F;
	}

	public void setFeed(float feed)
	{
		this.feed = feed;
	}

	public float getFeed()
	{
		return feed;
	}

	public void setBrain(float brain)
	{
		this.brain = brain;
	}

	public float getBrain()
	{
		return brain;
	}

	public void setHealth(float health)
	{
		this.health = health;
	}

	public float getHealth()
	{
		return health;
	}
}
