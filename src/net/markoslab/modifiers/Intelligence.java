package net.markoslab.modifiers;


import net.markoslab.stats.Stats;

/**
 * Created by marko on 1/4/15.
 */
public class Intelligence extends Modifier {

    public Intelligence(String description, float value) {
        this.description = description;
        this.value = value;
    }

    @Override
    public void update(Stats stats) {
        if (value > 0) stats.intelligence.increase(value);
        else if (value < 0) stats.intelligence.decrease(value);
    }

}
