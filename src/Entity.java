import java.util.*;

public class Entity
{

	private Game game;
	public Entity(Game game) {
		this.game = game;
	}

	public Entity addToWorld()
	{
		this.game.entities.add(this);
		return this;
	}
	
	public void update() {}

	public void die() {
		List<Entity> list = game.entities;
		Iterator<Entity> itr = list.iterator();
		while(itr.hasNext())
		{
			if (itr.next() == this) itr.remove();
		}
	}
	}
