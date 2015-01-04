package net.markoslab;

import java.util.*;

public class Modifier
{
	float period = -2.0F;
	long startTime = System.nanoTime();
	List<Modifier> list;
	String name;
	Player player;
	float value;
	
	private boolean isDone;

	
	public Modifier(Player player, float value, String name)
	{
		this.player = player;
		this.value = value;
		this.name = name;
		this.list = player.modifiers;
		list.add(this);
	}

	public Modifier(Player player, float value, float period, String name)
	{
		this.player = player;
		this.value = value;
		this.name = name;
		this.period = period;
		this.list = player.modifiers;
		list.add(this);
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
	
	public void update() {
		if (period == -1.0F)
		{
			isDone = true;
		}
		else if (period == -2.0F)
		{
			return;
		}
		else
		{
			long currentTime = System.nanoTime();
			if((currentTime - startTime) / 1000000  > period)
			{
				isDone = true;
			}
		}
		if (isDone) destroy();
	}

	public void destroy()
	{
		if (list.contains(this)) 
		{
			Iterator<Modifier> iter = list.iterator();
			while(iter.hasNext())
			{
				if (iter.next() == this) iter.remove();
			}
		}
	}
}
