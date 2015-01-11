package net.markoslab.modifiers;

import net.markoslab.Stats.Stats;

/**
 * Created by marko on 1/11/15.
 */
public class StatsModifier extends Modifier {
    private Type type;

    public StatsModifier(Type type, String description, float value) {
        this.type = type;
        this.description = description;
        this.value = value;
    }

    @Override
    public void update(Stats stats) {
        switch (type) {
            case HEALTH:
                if (value > 0) stats.health.increase(value);
                else if (value < 0) stats.health.decrease(value);
                break;
            case INTELLIGENCE:
                if (value > 0) stats.intelligence.increase(value);
                else if (value < 0) stats.intelligence.decrease(value);
                break;
            case STRENGTH:
                if (value > 0) stats.strength.increase(value);
                else if (value < 0) stats.strength.decrease(value);
                break;
        }
    }
}
