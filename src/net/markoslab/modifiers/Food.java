package net.markoslab.modifiers;

import net.markoslab.Player;

/**
 * Created by marko on 1/4/15.
 */
public class Food extends StatDecorator {
    private Modifier modifier;

    public Food(Modifier modifier, String description, float value) {
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
        player.setFeed(player.getFeed() + Player.toProcent(value));
    }

}
