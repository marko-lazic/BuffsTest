package net.markoslab;

import net.markoslab.modifiers.Food;
import net.markoslab.modifiers.Health;
import net.markoslab.modifiers.Modifier;
import net.markoslab.modifiers.Once;

/**
 * Created by marko on 1/1/15.
 */
public class ArtificialIntelligence
{


    private int applesCount = 1;
    private int healthPotionsCount = 1;

    public ArtificialIntelligence()
    {

    }

    public void update(Player player) {
        if (player.getFeed() < Player.toProcent(80) &&
                applesCount > 0)
        {
            Modifier foodModifier = new Once();
            player.addModifier(new Food(foodModifier, "Eat Apple +10", 10));
            applesCount--;
        }

        if (player.getHealth() < Player.toProcent(30) &&
                healthPotionsCount > 0) {
            Modifier healthModifier = new Once();
            player.addModifier(new Health(healthModifier, "Health Potion +30", 30));
            healthPotionsCount--;
        }

    }

}
