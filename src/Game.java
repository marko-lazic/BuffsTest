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
		new HealthModifier(player, -70, -1, "Damage from no where -70");
		new HealthModifier(player, 15, 3000, "Beginner luck +15");
		new HealthModifier(player, 0.5F, "Regen +0.5");
		new FoodModifier(player, -15, "Hunger -15");

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
