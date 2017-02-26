package engine.persons;

/**
 * Created by USER on 25.02.2017.
 */
public abstract class Aperson {


    private double x;
    private double y;

    private boolean isControl;

    private double health;
    private double maxHealth;
    private double regenerate;

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

    public boolean isControl() {
        return isControl;
    }

    public void setControl(boolean control) {
        isControl = control;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getRegenerate() {
        return regenerate;
    }

    public void setRegenerate(double regenerate) {
        this.regenerate = regenerate;
    }
}
