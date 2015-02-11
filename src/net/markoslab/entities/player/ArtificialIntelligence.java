package net.markoslab.entities.player;

import net.markoslab.Gui;
import net.markoslab.stats.Stat;
import net.markoslab.modifiers.Strength;
import net.markoslab.modifiers.Health;
import net.markoslab.modifiers.Modifier;
import net.markoslab.modifiers.Once;

/**
 * Created by marko on 1/1/15.
 */
public class ArtificialIntelligence {


    private int applesCount = 1;
    private int healthPotionsCount = 1;

    public ArtificialIntelligence() {

    }

    public void update(Player player) {
        if (player.getStats().strength.getCurrentPrecent() < Stat.toProcent(80) &&
                applesCount > 0) {
            Modifier foodModifier = new Strength("Double Cheese Burger +10", 10);
            player.getModifiers().add(new Once(foodModifier));
            applesCount--;
        }

        if (player.getStats().health.getCurrentPrecent() < Stat.toProcent(30) &&
                healthPotionsCount > 0) {
            Modifier healthModifier = new Health("Health Medkit +30", 30);
            player.getModifiers().add(new Once(healthModifier));
            healthPotionsCount--;
        }

        if (player.getStats().strength.getCurrent() <= 0) {
            Modifier hungerModifier = new Health("Starvation -5", -5);
            player.getModifiers().add(new Once(hungerModifier));
        }
        if (player.getStats().health.getCurrent() <= 0) {
            player.die();
            Gui.getInstance().clearScreen();
            Gui.getInstance().writeLine(2, 7, "Entity died.");
        }

    }

}
