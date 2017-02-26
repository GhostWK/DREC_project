package engine.window;

import engine.map.Tile;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;


/**
 * Created by USER on 20.02.2017.
 */
public class Camera {
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    private double x;
    private double y;

    private double scaling;
    @Override
    public String toString() {
        return "Camera{" +
                "x=" + x/ Tile.getSizeOfBlock() +
                ", y=" + y/ Tile.getSizeOfBlock() +
                '}';
    }

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
        scaling = 1;
    }

    void translate(Graphics g, Input input, GameContainer gc){
        int L = 20*100;
        int dWheel;
        g.drawString(this.toString(), 10,40);


        if( (dWheel = Mouse.getDWheel()) != 0){
            double temp = y;
            if(dWheel > 0 && scaling < 4){
                scaling += 0.5;

            }
            if(dWheel < 0 && scaling > 1){
                scaling -= 0.5;
            }
        }

        g.scale((float) scaling,(float)scaling);
        if(input.isKeyDown(Input.KEY_D)) x+=L/Tile.getSizeOfBlock();
        if(input.isKeyDown(Input.KEY_A)) x-=L/Tile.getSizeOfBlock();
        if(input.isKeyDown(Input.KEY_S)) y+=L/Tile.getSizeOfBlock();
        if(input.isKeyDown(Input.KEY_W)) y-=L/Tile.getSizeOfBlock();


        g.translate(-(float)x, -(float) y);
    }
}
