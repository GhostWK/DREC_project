package engine.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by sasha_zubkov on 20.02.17.
 */
public class Tile {
    public static int getSizeOfBlock() {
        return SIZE_OF_BLOCK;
    }

    public static void setSizeOfBlock(int sizeOfBlock) {
        SIZE_OF_BLOCK = sizeOfBlock;
    }

    private static int SIZE_OF_BLOCK = 32;
    public static final int MAX_SIZE_OF_BLOCK = 128;
    public static final int MIN_SIZE_OF_BLOCK = 32;
    public static final int STEP_SIZE_OF_BLOCK = 16;
    private int id;

    public static Image[] images = new Image[256];

    public static void initImages(){
        try {
            images[1] = new Image("D:\\Idea Projects\\MyProject-DREC\\src\\res\\land.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
