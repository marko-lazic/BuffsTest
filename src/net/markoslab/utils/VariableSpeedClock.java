package net.markoslab.utils;

public class VariableSpeedClock {

    private double speed;
    private long startTime;

    public VariableSpeedClock(double speed) {
        this(speed, System.currentTimeMillis());
    }

    public VariableSpeedClock(double speed, long startTime) {
        this.speed = speed;
        this.startTime = startTime;
    }

    public long getTime () {
        return (long) ((System.currentTimeMillis() - this.startTime) * this.speed + this.startTime);
    }
/*
    public static void main(String [] args) throws InterruptedException {

        long st = System.currentTimeMillis();
        VariableSpeedClock vsc = new VariableSpeedClock(2.3);

        Thread.sleep(1000);

        System.out.println(vsc.getTime() - st);
        System.out.println(System.currentTimeMillis() - st);

    }*/
}
