package net.markoslab;

public class HealthModifier extends MModifier
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
		super.update();
	}
}
