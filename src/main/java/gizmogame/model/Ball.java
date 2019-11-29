package gizmogame.model;

import gizmogame.physics.Vect;

public class Ball extends Components{

    private int size;
    private boolean absorbed;
    private Vect center;
    private Vect velocity;
    private int diameter;
    public final static double moveTime = 0.005;
    private int vx = 0;
    private int vy = 0;
    private Vect gravity = new Vect(0,0);




    public Ball(Vect origin, String name){

        super(origin,name);
        size = 1;
        absorbed = false;
        center = origin.plus((new Vect((bound.x() - origin.x())/2,(bound.y()-origin.y())/2)));
        velocity = new Vect(5,5);
        diameter = 20;
    }

    public void move(){

        int x = (int)center.x();
        int y = (int)center.y();

        vy = (int)velocity.plus(gravity).y();
        vx = (int)velocity.x();

        System.out.println(vy);

        x += vx;
        if (x <= diameter+10) {
            x = diameter+10;
            vx = -vx;
        }
        if (x >= 810 - diameter) {
            x = 810 - diameter;
            vx = -vx;
        }


        y += vy;
        if (y <= diameter+10) {
            y = diameter+10;
            vy = -vy;
        }
        if (y >= 810 - diameter) {
            y =  810 - diameter;
            vy = -vy;
        }

        velocity = new Vect(vx,vy);
        setCenter(new Vect(x,y));
        setOrigin(center.minus(new Vect(20,20)));
    }














    public Vect getOrigin() {
        return origin;
    }

    public String getName() {
        return name;
    }

    public void setOrigin(Vect origin) {
        this.origin = origin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCenter(Vect center) {
        this.center = center;
    }

    public void setVelocity(Vect velocity) {
        this.velocity = velocity;
    }
}
