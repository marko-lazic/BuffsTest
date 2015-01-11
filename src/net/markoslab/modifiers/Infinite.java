package net.markoslab.modifiers;

import net.markoslab.stats.Stats;

/**
 * Created by marko on 1/4/15.
 */
public class Infinite extends TimeDecorator {

    private Modifier modifier;

    public Infinite(Modifier modifier) {
        this.modifier = modifier;
        this.description = modifier.getDescription();
        this.value = modifier.getValue();
    }

    @Override
    public void update(Stats stats) {
        modifier.update(stats);
    }

    @Override
    public long getTimeLeft() {
        return 0;
    }
}
