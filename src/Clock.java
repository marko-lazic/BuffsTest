import java.util.TimerTask;

/**
 * Created by marko on 1/1/15.
 */
public class Clock extends TimerTask {
    private int timeInSeconds = 0;
    private int timeInMinutes = 0;
    private int timeInHours   = 0;
    private final Game game;

    public Clock(Game game) {
       this.game = game;
    }

    @Override
    public void run() {
        timeInSeconds++;
        if(timeInSeconds == 60)
        {
            timeInSeconds = 0;
            timeInMinutes++;
        }
        if (timeInMinutes == 60)
        {
            timeInMinutes = 0;
            timeInHours++;
        }
        if (timeInHours == 24)
        {
            timeInHours = 0;
        }
        System.out.print(this.toString() + " - ");
        game.update();
    }

    @Override
    public String toString() {
        return String.format("%d:%d:%d", timeInHours, timeInMinutes, timeInSeconds);
    }
}
