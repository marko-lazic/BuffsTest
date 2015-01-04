package net.markoslab.modifiers;

import net.markoslab.Player;

/**
 * Created by marko on 1/4/15.
 */
public class Intelligence extends Modifier {

    public Intelligence(String description, float value) {
        this.description = description;
        this.value = value;
    }

    @Override
    public void update(Player player) {
        player.setIntelligence(player.getIntelligence() + Player.toProcent(value));
    }

}
