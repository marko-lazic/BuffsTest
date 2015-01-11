package net.markoslab;

import net.markoslab.Player.Player;
import net.markoslab.modifiers.*;

import java.util.*;

public class Game
{
	List<Entity> entities = new ArrayList<Entity>();
	private Timer timer;
	private TimerTask clock;
	
	private void create()
	{
		timer = new Timer();
		clock = new Clock(this);
		timer.scheduleAtFixedRate(clock, 1000, 1000);
		Player player = new Player(this);
		player.addToWorld();

		//player.addModifier(new Once(new Health("Fire Damage -70", -70)));
		player.addModifier(new Once(new StatsModifier(Type.HEALTH, "Fire Damage -70", -70)));
		player.addModifier(new Timed(new Health("Beginner luck +15", 15), 3000));
		player.addModifier(new Infinite(new Health("Regen +0.5", .5f)));
//		player.addModifier(new Infinite(new Strength("Infinite Weakness -15", -15)));
		player.addModifier(new Infinite(new StatsModifier(Type.STRENGTH, "Infinite Weakness -15", -15)));


	}

	public void update()
	{
		// Update Entities
		if (!entities.isEmpty())
			for (int i = 0; i < entities.size(); i++)
			{
				entities.get(i).update();
			}
		
	}
	
	public void run()
	{
		create();
	}
}
