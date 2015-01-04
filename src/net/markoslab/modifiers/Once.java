package net.markoslab.modifiers;

import net.markoslab.Player;

/**
 * Created by marko on 1/4/15.
 */
public class Once extends Modifier {

    @Override
    public void update(Player player) {
        destroy(player.getModifiers());
    }
}
