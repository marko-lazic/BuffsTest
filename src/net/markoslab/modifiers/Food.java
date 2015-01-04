package net.markoslab.modifiers;

import net.markoslab.Player;

/**
 * Created by marko on 1/4/15.
 */
public class Food extends Modifier {

    public Food(String description, float value) {
        this.description = description;
        this.value = value;
    }

    @Override
    public void update(Player player) {
        player.setFeed(player.getFeed() + Player.toProcent(value));
    }

}
