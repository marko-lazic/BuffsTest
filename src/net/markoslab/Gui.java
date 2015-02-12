package net.markoslab;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by marko on 2/11/15.
 */
public class Gui {
    private static Gui guiSingleton;
    private static Terminal terminal;

    private static void init(){
        synchronized(Gui.class) {
            try {
                guiSingleton = new Gui();
                terminal = new DefaultTerminalFactory(System.out, System.in, Charset.forName("UTF8")).createTerminal();
                terminal.enterPrivateMode();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static Gui getInstance() {

        if(guiSingleton == null) {
            init();
        }
        return guiSingleton;
    }

    protected Gui() throws IOException{
        // Exists only to defeat instantiation.
    }

    /**
     * @param i Left and right
     * @param i1 Up and Down
     * @param str text string
     */
    public void writeLine(int i, int i1, String str) {
        char[] charArray = str.toCharArray();
        try {
            terminal.setCursorPosition(i, i1);
            for (char c : charArray) {
                terminal.putCharacter(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeLine(int i, int i1, String str, TextColor text, TextColor background) {
        try {
            terminal.setForegroundColor(text);
            terminal.setBackgroundColor(background);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeLine(i, i1, str);
        try {
            terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
            terminal.setBackgroundColor(TextColor.ANSI.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clearScreen() {
        try {
            terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
            terminal.setBackgroundColor(TextColor.ANSI.DEFAULT);
            terminal.clearScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush() {
        try {
            terminal.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            terminal.exitPrivateMode();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

