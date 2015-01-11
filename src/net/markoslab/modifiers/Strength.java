package net.markoslab.modifiers;


import net.markoslab.stats.Stats;

/**
 * Created by marko on 1/4/15.
 */
public class Strength extends Modifier {

    public Strength(String description, float value) {
        this.description = description;
        this.value = value;
    }

    @Override
    public void update(Stats stats) {
        if (value > 0) stats.strength.increase(value);
        else if (value < 0) stats.strength.decrease(value);
    }

}
