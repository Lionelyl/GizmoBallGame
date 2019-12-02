package gizmogame.model.gizmos;

import gizmogame.model.Collision;
import gizmogame.model.Components;
import gizmogame.physics.Vect;
import gizmogame.physics.LineSegment;
import gizmogame.physics.Vect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle extends Components {

    private int rotation;
    private int size;

    public Triangle(Vect origin, String name) {
        super(origin, name);
        rotation = 0;
        size = 1;

    }

    @Override
    public Vect calculateBound() {
        Vect origin = super.getOrigin();
        Vect bound = new Vect(1, 1);
        return origin.plus(bound);
    }

    public int getRotaion() {
        return rotation;
    }

    public int getSize() {
        return size;
    }

    public void setRotaion(int rotaion) {
        this.rotation = rotaion;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addSize(){
        size++;
    }

    @Override
    public boolean canRotate(){
        return true;
    }

    @Override
    public void handle(Collision collision) {

    }
}

