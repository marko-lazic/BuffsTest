package net.markoslab.modifiers;

import net.markoslab.MModifier;
import net.markoslab.Player;

import java.util.Iterator;
import java.util.List;

/**
 * Created by marko on 1/4/15.
 */
public class Timed extends Modifier {

    private final long period;
    private final long startTime = System.nanoTime();


    public Timed(Player player, long period) {
        super(player);
        this.period = period;
    }

    @Override
    public void update() {
        long currentTime = System.nanoTime();
        if((currentTime - startTime) / 1000000  > period)
        {
            destroy();
        }
    }

}
