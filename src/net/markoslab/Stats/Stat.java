package net.markoslab.Stats;

/**
 * Created by marko on 1/10/15.
 */
public class Stat {
    private float maxStat;
    private float currentStat;

    public Stat(float currentStat, float maxStat) {
        this.maxStat = maxStat;
        this.currentStat = currentStat;
    }

    public float getMax() {
        return maxStat;
    }

    public float getMaxPrecent() {
        return maxStat / maxStat;
    }

    public Stat setMax(float maxStat) {
        this.maxStat = maxStat;
        return this;
    }

    public float getCurrent() {
        return currentStat;
    }

    public float getCurrentPrecent() {
        return currentStat  / maxStat;
    }

    public Stat setCurrent(float currentStat) {
        this.currentStat = currentStat;
        return this;
    }

    public Stat increase(float stat) {
        this.currentStat += stat;
        if (this.currentStat > maxStat)
            this.currentStat = maxStat;
        return this;
    }

    public Stat decrease(float stat) {
        this.currentStat -= stat;
        if (this.currentStat < 0)
            this.currentStat = 0;
        return this;
    }

    public Stat increasePrecent(float stat) {
        this.increase(stat * (maxStat / 100.0F));
        return this;
    }

    public Stat decreasePrecent(float stat) {
        this.decrease(stat * (maxStat / 100.0F));
        return this;
    }
}
