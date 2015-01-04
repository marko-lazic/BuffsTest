package net.markoslab.modifiers;

/**
 * Created by marko on 1/4/15.
 */
public abstract class Modifier {

    String description;

    public abstract void update();

    public abstract void destroy();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
