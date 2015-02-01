package net.markoslab;

import net.markoslab.entities.player.Player;
import net.markoslab.modifiers.*;
import net.markoslab.utils.Time;
import net.markoslab.utils.VariableSpeedClock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by marko on 2/1/15.
 */
public class BuffsTest implements Game {
    //public List<Entity> entities = new ArrayList<Entity>();
    public World world;
    private Calendar cal = Calendar.getInstance();
    private VariableSpeedClock speedClock = new VariableSpeedClock(250);
    private Date date = cal.getTime();
    private Date gameDate = new Date(speedClock.getTime());
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
    Time time;

    public void create()
    {

        time = new Time(this);
        this.world = new World(this);
        Player player = new Player(world);
        player.addToWorld();

        player.getModifiers().add(new Once(new StatsModifier(Type.HEALTH, "Fire Damage -70", -70)));
        player.getModifiers().add(new Timed(new Health("Beginner luck +15", 15), 3000));
        player.getModifiers().add(new Infinite(new Health("Regen +0.5", .5f)));
        player.getModifiers().add(new Infinite(new StatsModifier(Type.STRENGTH, "Infinite Weakness -15", -15)));

        cal.add(Calendar.YEAR, 200);



    }

    public void update() {
        //world.update();
        date = cal.getTime();
        gameDate = new Date(speedClock.getTime());
        //System.out.println("Normal date: " + format.format(date)); //OR
        System.out.println("Game date: " + format.format(gameDate)); //OR
    }

}
