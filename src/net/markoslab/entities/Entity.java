package net.markoslab.entities;

import net.markoslab.World;

import java.util.*;

public abstract class Entity
{

	private World world;
	public Entity(World world) {
		this.world = world;
	}

	public Entity addToWorld()
	{
		this.world.entities.add(this);
		return this;
	}
	
	public void update() {}

	public void die() {
		List<Entity> list = world.entities;
		Iterator<Entity> itr = list.iterator();
		while(itr.hasNext())
		{
			if (itr.next() == this) itr.remove();
		}
	}
	}
