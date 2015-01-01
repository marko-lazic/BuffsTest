import java.util.*;
import java.util.concurrent.*;
import java.sql.*;

public class Modifier
{
	float timeLenght;
	long startTime = System.nanoTime();
	List<Modifier> list;
	String name;
	Player player;
	float value;
	
	private boolean timeComplete;

	
	public Modifier(Player player, float value, String name)
	{
		this.player = player;
		this.value = value;
		this.name = name;
		this.list = player.modifiers;
		list.add(this);
	}

	public Modifier(Player player, float value, float timeLenght, String name)
	{
		this.player = player;
		this.value = value;
		this.name = name;
		this.timeLenght = timeLenght;
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
		if (timeComplete) {destroy(); return;}
		if (!(timeLenght <= 0.0F)) {
			long currentTime = System.nanoTime();
			if((currentTime - startTime) / 1000000  >= timeLenght) {
				timeComplete = true;
			}
		} else if (timeLenght == -1.0F)
		{
			timeComplete = true;
			destroy();
		}
		
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
