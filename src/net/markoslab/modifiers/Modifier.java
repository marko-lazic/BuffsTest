package net.markoslab.modifiers;

import net.markoslab.Player;

import java.util.Iterator;
import java.util.List;

/**
 * Created by marko on 1/4/15.
 */
public abstract class Modifier {

    private String description = "Unknown modifier.";

    public abstract void update(Player player);

    public void destroy(List<Modifier> list) {
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
