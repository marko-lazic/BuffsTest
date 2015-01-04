package net.markoslab;

import net.markoslab.modifiers.Modifier;

import java.util.*;

public class Player extends Entity
{
	float health = 1.0F;
	float intelligence = 1.0F;
	float feed = 0.90F;
	private ArtificialIntelligence artificialIntelligence;

	public List<Modifier> getModifiers() {
		return modifiers;
	}

	private List<Modifier> modifiers = new ArrayList<Modifier>();
	
	public Player(Game game)
	{
		super(game);
		artificialIntelligence = new ArtificialIntelligence();
		printStat("");
	}
	
	public void update()
	{
		artificialIntelligence.update(this);

		for (int i = 0; i < modifiers.size(); i++)
		{
			modifiers.get(i).update();
		}
		printStat(toModifierString());
		if (feed <= 0) {
			new HealthModifier(this, -5, -1, "Starvation -5");
		}
		if (health <= 0)
		{
			System.out.print("net.markoslab.Player died.");
			die();
		}
	}
	
	public void printStat(String modifierNames)
	{
		
		System.out.print("h: " + (int) ( getHealth() * 100) + " " + 
							"f: " + (int) ( getFeed() * 100) + " " +
							"b: " + (int) ( getIntelligence() * 100));
		System.out.print(modifierNames);
		System.out.println();
	}

	private String toModifierString()
	{
		String modifierNames = "";
		if (!modifiers.isEmpty())
		{
			for (Modifier m : modifiers) { modifierNames += ", " + m.getDescription();}
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
		if (this.feed < 0.0F) this.feed = 0.0F;
		if (this.feed > 1.0F) this.feed = 1.0F;
	}

	public float getFeed()
	{
		return feed;
	}

	public void setIntelligence(float intelligence)
	{
		this.intelligence = intelligence;
		if (this.intelligence < 0.0F)  this.intelligence = 0.0F;
		if (this.intelligence > 1.0F) this.intelligence = 1.0F;
	}

	public float getIntelligence()
	{
		return intelligence;
	}

	public void setHealth(float health)
	{
		this.health = health;
		if (this.health < 0.0F) this.health = 0.0F;
		if (this.health > 1.0F) this.health = 1.0F;
	}

	public float getHealth()
	{
		return health;
	}
}
