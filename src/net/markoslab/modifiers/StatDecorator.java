package net.markoslab.modifiers;

/**
 * Created by marko on 1/4/15.
 */
public abstract class StatDecorator extends Modifier {
    protected float value;

    public StatDecorator(String description, float value) {
        setDescription(description);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public Modifier setValue(float value) {
        this.value = value;
        return this;
    }

}
