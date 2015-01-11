package net.markoslab.modifiers;

import net.markoslab.Stats.Stats;

/**
 * Created by marko on 1/4/15.
 */
public class Timed extends TimeDecorator {

    private Modifier modifier;
    private long currentTime = 0;
    private final long period;
    private final long startTime;

    /**
     * @param period How long until modifier is done.
     *               <p/>
     *               If period and "app tick" are equal update will return before calling Decorator update.
     */
    public Timed(Modifier modifier, long period) {
        this.modifier = modifier;
        this.period = period;
        this.description = modifier.getDescription();
        this.value = modifier.getValue();
        startTime = System.nanoTime();
    }

    @Override
    public void update(Stats stats) {
        currentTime = System.nanoTime();
        if ((currentTime - startTime) / 1000000 > period) {
            setDone(true);
        }
        modifier.update(stats);
    }

    @Override
    public long getTimeLeft() {
        return period - (currentTime - startTime) / 1000000;
    }

}
