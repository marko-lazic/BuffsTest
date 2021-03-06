package net.markoslab.entities.player;

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
        printStat("");
    }

    public void update() {
        artificialIntelligence.update(this);
        modifiers.update(this);
        printStat(modifiers.toString());
    }

    public void printStat(String modifierNames) {
        System.out.print("h: " + (int) (stats.health.getCurrent()) + " " +
                "s: " + (int) (stats.strength.getCurrent()) + " " +
                "i: " + (int) (stats.intelligence.getCurrent()));
        System.out.print(modifierNames);
        System.out.println();
    }

    public Stats getStats() {
        return this.stats;
    }

    public Modifiers getModifiers() {
        return this.modifiers;
    }
}