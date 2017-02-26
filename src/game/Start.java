package game;

import engine.map.Tile;
import engine.window.Window;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import res.Loader;

/**
 * Created by USER on 20.02.2017.
 */
public class Start {
    public static final String TITLE = "Game";
    public static final int HEIGHT = 720;
    public static final int WIDTH = 1280;
    public static final boolean IS_FULLSCREEN = false;


    private static AppGameContainer appgc;


    public static void main(String[] args) {
        new Thread(new Loader()).start();
        try {
            appgc = new AppGameContainer(new Window(TITLE));
            appgc.setDisplayMode(WIDTH,HEIGHT,IS_FULLSCREEN);


            appgc.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }



}
