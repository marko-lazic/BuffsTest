package net.markoslab.modifiers;

import net.markoslab.Stats.Stats;

/**
 * Created by marko on 1/4/15.
 */
public class Health extends Modifier {

    public Health(String description, float value) {
        this.description = description;
        this.value = value;
    }

    @Override
    public void update(Stats stats) {
        if (value > 0) stats.health.increase(value);
        else if (value < 0) stats.health.decrease(value);
    }

}
