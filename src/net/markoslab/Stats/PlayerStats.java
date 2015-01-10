package net.markoslab.Stats;

/**
 * Created by marko on 1/10/15.
 */
public class PlayerStats {

    private Stat health;
    private Stat intelligence;
    private Stat food;

    public PlayerStats() {
        this.health = new Stat(100, 100);
        this.intelligence = new Stat(100, 100);
        this.food = new Stat(100, 100);
    }

    public Stat getHealth() {
        return health;
    }

    public void setHealth(Stat health) {
        this.health = health;
    }

    public PlayerStats(Stat health, Stat intelligence, Stat food) {
        this.health = health;
        this.intelligence = intelligence;
        this.food = food;
    }

    public Stat getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Stat intelligence) {
        this.intelligence = intelligence;
    }

    public Stat getFood() {
        return food;
    }

    public void setFood(Stat food) {
        this.food = food;
    }


}
