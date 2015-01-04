package net.markoslab.modifiers;

import net.markoslab.Player;

import java.util.List;

/**
 * Created by marko on 1/4/15.
 */
public class Once extends TimeDecorator {
    private Modifier modifier;
    private boolean isOnce = false;

    public Once(Modifier modifier) {
        this.modifier = modifier;
        this.description = modifier.getDescription();
        this.value = modifier.getValue();
    }

    @Override
    public void update(Player player) {
        if (isOnce) {
            setDone(true);
        } else {
            modifier.update(player);
        }
        isOnce = true;
    }

    @Override
    public long getTimeLeft() {
        return 0;
    }
}
