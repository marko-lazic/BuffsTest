package net.markoslab.entities.player;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import net.markoslab.Gui;
import net.markoslab.World;
import net.markoslab.entities.Entity;
import net.markoslab.stats.Stat;
import net.markoslab.stats.Stats;
import net.markoslab.modifiers.*;

public class Player extends Entity {
    private Stats stats = new Stats(new Stat(100, 100), new Stat(100, 100), new Stat(90, 100));
    private Modifiers modifiers = new Modifiers();
    private ArtificialIntelligence artificialIntelligence = new ArtificialIntelligence();

    public Player(World world) {
        super(world);
    }

    public void update() {
        artificialIntelligence.update(this);
        modifiers.update(this);
        printStat(modifiers.toString());
    }

    public void printStat(String modifierNames) {
        String statsToString = Symbols.HEART + ": " + (int) (stats.health.getCurrent()) + " " +
                "STRENGTH: " + (int) (stats.strength.getCurrent()) + " " +
                "INTELLIGENCE: " + (int) (stats.intelligence.getCurrent());
        Gui.getInstance().writeLine(2, 4, statsToString);
        Gui.getInstance().writeLine(2, 5, "--------MODIFIERS--------");
        String[] mods = modifierNames.split(", ");
        for (int iter = 0; iter < mods.length; iter++) {
            if (mods[iter].contains("Double Cheese Burger +10") || // GREEN
                    mods[iter].contains("Health Medkit +30") ||
                    mods[iter].contains("Beginner luck +15") ||
                    mods[iter].contains("Regen +0.5")) {
                Gui.getInstance().writeLine(2, 5 + iter, mods[iter],TextColor.ANSI.GREEN, TextColor.ANSI.DEFAULT);

            } else if (mods[iter].contains(("Fire Damage -70")) || // RED
                        mods[iter].contains("Infinite Weakness -4") ||
                        mods[iter].contains(("Starvation -5" ))) {
                Gui.getInstance().writeLine(2, 5 + iter, mods[iter], TextColor.ANSI.RED, TextColor.ANSI.DEFAULT);
            } else { // WHITE
                Gui.getInstance().writeLine(2, 5 + iter, mods[iter], TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT);
            }
        }

    }

    public Stats getStats() {
        return this.stats;
    }

    public Modifiers getModifiers() {
        return this.modifiers;
    }
}