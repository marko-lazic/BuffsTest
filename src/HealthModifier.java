public class HealthModifier extends Modifier
{

	public HealthModifier(Player player, float value, float period, String name)
	{
		super(player, value, period, name);
	}
	
	public HealthModifier(Player player, float value, String name)
	{
		super(player, value, name);
	}

	@Override
	public void update()
	{
		player.setHealth(player.getHealth() + Player.toProcent(value));
		if (player.getHealth() > Player.toProcent(100)) {
			player.setHealth(Player.toProcent(100));
		}
		super.update();
	}
}
