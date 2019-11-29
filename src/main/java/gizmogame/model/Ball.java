package gizmogame.model;

import gizmogame.physics.Vect;

public class Ball extends Components{

    private int size;
    private boolean absorbed;
    private Vect center;
    private Vect velocity;
    private int diameter;
    public final static double moveTime = 0.005;

    public Ball(Vect origin, String name){

        super(origin,name);
        size = 1;
        absorbed = false;
        center = origin.plus((new Vect((bound.x() - origin.x())/2,(bound.y()-origin.y())/2)));
        velocity = new Vect(10,10);
        diameter = 20;
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
}
