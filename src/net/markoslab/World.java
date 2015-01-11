package net.markoslab;

import net.markoslab.entities.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marko on 1/11/15.
 */
public class World {
    public List<Entity> entities = new ArrayList<Entity>();
    private Game game;

    public World(Game game) {
        this.game = game;
    }

    public World update() {
        if (!entities.isEmpty())
            for (int i = 0; i < entities.size(); i++)
            {
                entities.get(i).update();
            }
        return this;
    }
}
