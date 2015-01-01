public class HealthModifier extends Modifier
{
	Player player;
	float value;
	public HealthModifier(Player player, float value, float time, String name) 
	{
		super(player, value, time, name);
		super.name = name;
		this.player = player;
		this.value = value;
	}
	
	public HealthModifier(Player player, float value, String name)
	{
		super (player, value, -1, name);
		super.name = name;
		this.player = player;
		this.value = value;
	}

	@Override
	public void update()
	{
		super.update();
		player.setHealth(player.getHealth() + Player.toProcent(value));
		if (player.getHealth() > Player.toProcent(100))
			player.setHealth(Player.toProcent(100));
	}
}
