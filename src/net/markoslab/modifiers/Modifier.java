package net.markoslab.modifiers;

import net.markoslab.stats.Stats;

/**
 * Created by marko on 1/4/15.
 */
public abstract class Modifier {

    protected String description = "Unknown modifier.";
    protected boolean isDone = false;
    protected float value;

    public abstract void update(Stats stats);

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
