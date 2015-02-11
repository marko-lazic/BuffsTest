package net.markoslab.entities.player;

import com.googlecode.lanterna.Symbols;
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
        Gui.getInstance().writeLine(2, 5, modifierNames);
    }

    public Stats getStats() {
        return this.stats;
    }

    public Modifiers getModifiers() {
        return this.modifiers;
    }
}