package net.markoslab;

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

		Modifier fireModifier = new Health("Fire Damage -70", -70);
		player.addModifier(new Once(fireModifier));
		Modifier beginnerLuck = new Health("Beginner luck +15", 15);
		player.addModifier(new Timed(beginnerLuck, 3000));
		Modifier regenModifier = new Health("Regen +0.5", .5f);
		player.addModifier(new Infinite(regenModifier));
		Modifier hungerModifier = new Food("Hunger -15", -15);
		player.addModifier(new Infinite(hungerModifier));

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
