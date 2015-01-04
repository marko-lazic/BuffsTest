package net.markoslab;

public class FoodModifier extends Modifier
{

	@Override
	public void update()
	{
		player.setFeed(player.getFeed() + Player.toProcent(value));
		super.update();
	}
	
	public FoodModifier(Player player, float value, String name)
	{
		super(player, value, name);
	}
	
	public FoodModifier(Player player, float value, float period, String name)
	{
		super(player, value, period, name);
	}
	
	
}
