package net.markoslab.modifiers;

import net.markoslab.Player;

/**
 * Created by marko on 1/4/15.
 */
public class Health extends StatDecorator {

    public Health(String description, float value) {
        super(description, value);
    }

    @Override
    public void update(Player player) {
        player.setHealth(player.getHealth() + Player.toProcent(value));
    }


}
