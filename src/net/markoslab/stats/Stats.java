package net.markoslab.stats;

/**
 * Created by marko on 1/10/15.
 */
public class Stats {

    public Stat health;
    public Stat intelligence;
    public Stat strength;

    public Stats() {
        this.health = new Stat(100, 100);
        this.intelligence = new Stat(100, 100);
        this.strength = new Stat(100, 100);
    }

    public Stats(Stat health, Stat intelligence, Stat food) {
        this.health = health;
        this.intelligence = intelligence;
        this.strength = food;
    }
}
