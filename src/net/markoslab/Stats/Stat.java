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
        return currentStat / maxStat;
    }

    public Stat setCurrent(float currentStat) {
        this.currentStat = currentStat;
        return this;
    }

    public Stat increase(float value) {
        this.currentStat += value;
        if (this.currentStat > maxStat)
            this.currentStat = maxStat;
        return this;
    }

    public Stat decrease(float value) {
        value = Math.abs(value);
        this.currentStat -= value;
        if (this.currentStat < 0)
            this.currentStat = 0;
        return this;
    }

    public Stat increasePrecent(float value) {
        this.increase(value * (maxStat / 100.0F));
        return this;
    }

    public Stat decreasePrecent(float value) {
        this.decrease(value * (maxStat / 100.0F));
        return this;
    }

    public static float toProcent(float value) {
        return value / 100.0F;
    }
}
