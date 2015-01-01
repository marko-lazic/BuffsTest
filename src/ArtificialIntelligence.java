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
            new FoodModifier(player, 10, -1, "Eat Apple +10");
            applesCount--;
        }

        if (player.getHealth() < Player.toProcent(30) &&
                healthPotionsCount > 0) {
            new HealthModifier(player, 30, -1, "Health Potion +30");
            healthPotionsCount--;
        }

    }

}
