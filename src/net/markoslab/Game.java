package net.markoslab;

import net.markoslab.entities.Entity;
import net.markoslab.entities.player.Player;
import net.markoslab.modifiers.*;

import java.util.*;

public class Game
{
	//public List<Entity> entities = new ArrayList<Entity>();
	public World world;
	private Timer timer;
	private TimerTask clock;
	
	private void create()
	{
		timer = new Timer();
		clock = new Clock(this);
		timer.scheduleAtFixedRate(clock, 1000, 1000);
		this.world = new World(this);
		Player player = new Player(world);
		player.addToWorld();

		player.getModifiers().add(new Once(new StatsModifier(Type.HEALTH, "Fire Damage -70", -70)));
		player.getModifiers().add(new Timed(new Health("Beginner luck +15", 15), 3000));
		player.getModifiers().add(new Infinite(new Health("Regen +0.5", .5f)));
		player.getModifiers().add(new Infinite(new StatsModifier(Type.STRENGTH, "Infinite Weakness -15", -15)));


	}

	public void update()
	{
		world.update();
	}
	
	public void run()
	{
		create();
	}
}
