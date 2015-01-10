package net.markoslab.Player;

import net.markoslab.Entity;
import net.markoslab.Game;
import net.markoslab.Stats.Stat;
import net.markoslab.Stats.Stats;
import net.markoslab.modifiers.*;

import java.util.*;

public class Player extends Entity
{
	private Stats stats = new Stats(new Stat(100, 100), new Stat(100, 100), new Stat(90, 100));
	private ArtificialIntelligence artificialIntelligence;

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
			modifiers.get(i).update(getStats());
			if (modifiers.get(i).isDone()) {
				modifiers.remove(modifiers.get(i));
			}
		}
		String modifierDescription = toModifierString();
		printStat(modifierDescription);

		if (stats.strength.getCurrent() <= 0) {
			Modifier hungerModifier = new Health("Starvation -5", -5);
			modifiers.add(new Once(hungerModifier));
		}
		if (stats.health.getCurrent() <= 0)
		{
			System.out.print("Player died.");
			die();
		}
	}

	public void printStat(String modifierNames)
	{

		System.out.print("h: " + (int) (stats.health.getCurrent()) + " " +
							"s: " + (int) (stats.strength.getCurrent()) + " " +
							"i: " + (int) ( stats.intelligence.getCurrent()));
		System.out.print(modifierNames);
		System.out.println();
	}

	private String toModifierString()
	{
		String modifierNames = "";
		if (!modifiers.isEmpty())
		{
			for (int i = 0; i < modifiers.size(); i++) {
				if (modifiers.get(i) instanceof Timed) {
					modifierNames += ", " + modifiers.get(i).getDescription() + " [" + ((Timed) modifiers.get(i)).getTimeLeft() + "]";
				}
				else
					modifierNames += ", " + modifiers.get(i).getDescription();
			}
		}
		return modifierNames;
	}

	public List<Modifier> getModifiers() {
		return modifiers;
	}

	public Player addModifier(Modifier modifier) {
		this.modifiers.add( modifier);
		return this;
	}

	public Stats getStats() {
		return this.stats;
	}
}
