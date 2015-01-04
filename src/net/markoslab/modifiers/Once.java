package net.markoslab.modifiers;

import net.markoslab.Player;

import java.util.List;

/**
 * Created by marko on 1/4/15.
 */
public class Once extends Modifier {
    private boolean isOnce = false;
    @Override
    public void update(Player player) {
        if (isOnce)
            setDone(true);
        isOnce = true;
    }

}
