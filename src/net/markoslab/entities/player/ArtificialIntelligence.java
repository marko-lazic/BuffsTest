package net.markoslab.entities.player;

import com.googlecode.lanterna.Symbols;
import net.markoslab.Gui;
import net.markoslab.modifiers.Health;
import net.markoslab.modifiers.Modifier;
import net.markoslab.modifiers.Once;
import net.markoslab.modifiers.Strength;
import net.markoslab.stats.Stat;

/**
 * Created by marko on 1/1/15.
 */
public class ArtificialIntelligence {


    private int applesCount = 3;
    private int medkitCount = 3;

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
                medkitCount > 0) {
            Modifier healthModifier = new Health("Health Medkit +30", 30);
            player.getModifiers().add(new Once(healthModifier));
            medkitCount--;
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
        Gui.getInstance().writeLine(2, 13, "-------Inventory------");
        Gui.getInstance().writeLine(2, 14, "Apples +10: " + applesCount + "/3");
        Gui.getInstance().writeLine(2, 15, "Medkits +30: " + medkitCount + "/3");
        Gui.getInstance().writeLine(2, 16, "-------Info------");
        Gui.getInstance().writeLine(2, 17, "AI will use Apples at less than 80% of STRENGTH");
        Gui.getInstance().writeLine(2, 18, "AI will use Medkits at less than 30% of " + Symbols.HEART);

    }

}
