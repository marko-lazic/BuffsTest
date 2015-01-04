package net.markoslab.modifiers;

import net.markoslab.Player;

/**
 * Created by marko on 1/4/15.
 */
public class Health extends StatDecorator {
    private Modifier modifier;

    public Health(Modifier modifier, String description, float value) {
        super(description, value);
        this.modifier = modifier;
    }

    @Override
    public void update(Player player) {
        modifier.update(player);
        if (modifier.isDone()) {
            setDone(true);
            return;
        }
        player.setHealth(player.getHealth() + Player.toProcent(value));
    }

}
