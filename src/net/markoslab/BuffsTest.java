package net.markoslab;

import net.markoslab.entities.player.Player;
import net.markoslab.modifiers.*;
import net.markoslab.utils.VariableSpeedClock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by marko on 2/1/15.
 */
public class BuffsTest implements Game {
    // TODO: make world of enitites -> public List<Entity> entities = new ArrayList<Entity>();
    public World world;

    private final double TIME_SPEED_MODIFIER = 4;

    private Calendar cal = Calendar.getInstance();
    Calendar gameCal =  new GregorianCalendar.Builder().build();
    private Date realDate = cal.getTime();
    private VariableSpeedClock speedClock = new VariableSpeedClock(TIME_SPEED_MODIFIER, gameCal.getTimeInMillis());
    private Date gameDate = new Date(speedClock.getTime());
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
    public void create()
    {
        Gui.getInstance();
        this.world = new World(this);
        Player player = new Player(world);
        player.addToWorld();

        player.getModifiers().add(new Once(new StatsModifier(Type.HEALTH, "Fire Damage -70", -70)));
        player.getModifiers().add(new Timed(new Health("Beginner luck +15", 15), 3000));
        player.getModifiers().add(new Infinite(new Health("Regen +0.5", .5f)));
        player.getModifiers().add(new Infinite(new StatsModifier(Type.STRENGTH, "Infinite Weakness -15", -15)));

    }

    public void update() {
        Gui.getInstance().clearScreen();
        world.update();
        realDate = cal.getTime();
        gameDate = new Date(speedClock.getTime());
        Gui.getInstance().writeLine(1,1, "Real date: " + dateFormat.format(realDate));
        Gui.getInstance().writeLine(1,2, "           " + timeFormat.format(realDate));
        Gui.getInstance().writeLine(40,1, "Game date: " + dateFormat.format(gameDate));
        Gui.getInstance().writeLine(40,2, "           " + timeFormat.format(gameDate));
        Gui.getInstance().flush();
    }


}
