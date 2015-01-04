package net.markoslab.modifiers;

import net.markoslab.Player;

import java.util.Iterator;
import java.util.List;

/**
 * Created by marko on 1/4/15.
 */
public abstract class Modifier {

    private String description = "Unknown modifier.";
    private boolean isDone = false;

    public abstract void update(Player player);

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
