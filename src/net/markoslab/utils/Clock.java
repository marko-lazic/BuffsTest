package net.markoslab.utils;

import net.markoslab.Game;

import java.util.TimerTask;

/**
 * Created by marko on 1/1/15.
 */

public class Clock extends TimerTask {
    private final Game game;
    public Clock(Game game) {
       this.game = game;
    }

    @Override
    public void run() {
        game.update();
    }

}

