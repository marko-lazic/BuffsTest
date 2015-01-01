import java.util.*;

public class Game
{
	List<Entity> entities = new ArrayList<Entity>();
	
	private void create()
	{
		Player player = new Player(this);
		player.addToWorld();
		HealthModifier damageFromNowhere = new HealthModifier(player, -70, "Damage from no where -70");
		HealthModifier beginerLuck = new HealthModifier(player, 15, 3000, "Beginner luck +15");
		HealthModifier nturalRegen = new HealthModifier(player, 0.5F, 0, "Regen +0.5");
	}

	private void update()
	{
		// Update Entities
		for (Entity e : entities) { e.update(); }
		
	}
	
	public void run()
	{
		create();

		while (true)
		{
			// Game loop
			update();
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{}
		}
	}
}
