package net.markoslab.modifiers;

import net.markoslab.Player;

import java.util.Iterator;
import java.util.List;

/**
 * Created by marko on 1/4/15.
 */
public abstract class Modifier {

    protected List<Modifier> list;
    protected Player player;
    private String description;

    public Modifier(Player player) {
        this.player = player;
        this.list = player.getModifiers();

    }

    public abstract void update();

    public void destroy() {
        if (list.contains(this))
        {
            Iterator<Modifier> iter = list.iterator();
            while(iter.hasNext())
            {
                if (iter.next() == this) iter.remove();
            }
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
