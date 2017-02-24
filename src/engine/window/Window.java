package engine.window;

import engine.map.Generation;
import engine.map.Map;
import org.newdawn.slick.*;

import java.util.ArrayList;

/**
 * Created by USER on 20.02.2017.
 */
public class Window extends BasicGame{
    int[] arr;
    Camera camera;
    Input input;
    Map map;
    public Window(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameContainer.setTargetFrameRate(60);
        gameContainer.setAlwaysRender(true);
        gameContainer.setVSync(true);




        camera = new Camera(0,250 * 32);
        input = gameContainer.getInput();
        map = new Map();
        arr = Generation.getRandomLeft(400,70,120,Generation.PLAIN,Generation.PLAIN);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        input = gameContainer.getInput();
        map.checkEndChunks(camera);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawString("Chunks are loaded: " + map.getChunksSize(), 10,60);

        camera.translate(graphics, input);

        map.drawChunks(graphics, camera);

    }
}
