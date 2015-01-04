package net.markoslab.modifiers;

import net.markoslab.Player;

/**
 * Created by marko on 1/4/15.
 */
public class Timed extends Modifier {

    private final long period;
    private final long startTime = System.nanoTime();


    public Timed(long period) {
        this.period = period;
    }

    @Override
    public void update(Player player) {
        long currentTime = System.nanoTime();
        if((currentTime - startTime) / 1000000  > period)
        {
            destroy(player.getModifiers());
        }
    }

}
