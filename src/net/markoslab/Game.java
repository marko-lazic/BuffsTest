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
		/*new HealthModifier(player, -70, -1, "Damage from no where -70");
		new HealthModifier(player, 15, 3000, "Beginner luck +15");
		new HealthModifier(player, 0.5F, "Regen +0.5");
		new FoodModifier(player, -15.0F, "Hunger -15");*/

		Modifier fireModifier = new Once();
		player.addModifier(new Health(fireModifier, "Fire Damage -70", -70));
		Modifier beginnerLuck = new Timed(3000);
		player.addModifier(new Health(beginnerLuck, "Beginner luck +15", 15));
		Modifier regenModifier = new Infinite();
		player.addModifier(new Health(regenModifier, "Regen +0.5", .5f));
		Modifier hungerModifier = new Infinite();
		player.addModifier(new Food(hungerModifier, "Hunger -15", -15));

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
