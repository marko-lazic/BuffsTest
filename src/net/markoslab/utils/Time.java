package net.markoslab.utils;

import net.markoslab.Game;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by marko on 2/1/15.
 */
public class Time {
    private Timer timer;
    private TimerTask clock;
    public final int DELAY = 1000;

    public Time(final Game game) {
        timer = new Timer();
        clock = new Clock(game);
        timer.scheduleAtFixedRate(clock, DELAY, DELAY);
    }

}
