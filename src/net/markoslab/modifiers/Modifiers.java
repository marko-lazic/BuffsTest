package net.markoslab.modifiers;


import net.markoslab.Player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marko on 1/11/15.
 * This class could have programmed Constructor that takes List<Modifier> modifiers as parameter.
 * Then it would deprecate logic from data. As its now it has logic and data and updates player.
 */
public class Modifiers {

    private List<Modifier> modifiers = new ArrayList<Modifier>();


    public Modifiers update(Player player) {
        for (int i = 0; i < modifiers.size(); i++)
        {
            modifiers.get(i).update(player.getStats());
            if (modifiers.get(i).isDone()) {
                modifiers.remove(modifiers.get(i));
            }
        }

        return this;
    }

    public String toModifierString()
    {
        String modifierNames = "";
        if (!modifiers.isEmpty())
        {
            for (int i = 0; i < modifiers.size(); i++) {
                if (modifiers.get(i) instanceof Timed) {
                    modifierNames += ", " + modifiers.get(i).getDescription() + " [" + ((Timed) modifiers.get(i)).getTimeLeft() + "]";
                }
                else
                    modifierNames += ", " + modifiers.get(i).getDescription();
            }
        }
        return modifierNames;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public Modifiers setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public Modifiers add(Modifier modifier) {
        this.modifiers.add( modifier);
        return this;
    }

    public Modifiers remove(Modifier modifier) {
        this.modifiers.remove(modifier);
        return this;
    }
}
