package engine.window;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * Created by USER on 20.02.2017.
 */
public class Camera {
    double x;
    double y;

    @Override
    public String toString() {
        return "Camera{" +
                "x=" + x/32 +
                ", y=" + y/32 +
                '}';
    }

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void translate(Graphics g, Input input){
        int L = 30;

        if(input.isKeyDown(Input.KEY_D)) x+=L;
        if(input.isKeyDown(Input.KEY_A)) x-=L;
        if(input.isKeyDown(Input.KEY_S)) y+=L;
        if(input.isKeyDown(Input.KEY_W)) y-=L;
        g.drawString(this.toString(), 10,40);
        g.translate(-(float)x, -(float) y);
    }
}
