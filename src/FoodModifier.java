public class FoodModifier extends Modifier
{

	@Override
	public void update()
	{
		super.update();
		player.setFeed(player.getFeed() + Player.toProcent(value));
	}
	
	public FoodModifier(Player player, float value, String name)
	{
		super(player, value, name);
	}
	
	public FoodModifier(Player player, float value, float timeLenght, String name)
	{
		super(player, value, timeLenght, name);
	}
	
	
}
