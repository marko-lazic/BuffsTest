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

	private Modifiers modifiers = new Modifiers();

	public Player(Game game)
	{
		super(game);
		artificialIntelligence = new ArtificialIntelligence();
		printStat("");
	}

	public void update()
	{
		artificialIntelligence.update(this);
		modifiers.update(this);

		String modifierDescription = modifiers.toModifierString();
		printStat(modifierDescription);
	}

	public void printStat(String modifierNames)
	{
		System.out.print("h: " + (int) (stats.health.getCurrent()) + " " +
							"s: " + (int) (stats.strength.getCurrent()) + " " +
							"i: " + (int) ( stats.intelligence.getCurrent()));
		System.out.print(modifierNames);
		System.out.println();
	}

	public Stats getStats() {
		return this.stats;
	}
	public Modifiers getModifiers() {
		return this.modifiers;
	}
}