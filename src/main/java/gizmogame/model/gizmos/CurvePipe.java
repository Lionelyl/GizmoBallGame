package gizmogame.model.gizmos;

import gizmogame.model.Components;
import gizmogame.physics.Vect;

public class CurvePipe extends Components {

    private int rotaion;
    private int size;

    public CurvePipe(Vect origin, String name) {
        super(origin, name);
        rotaion = 0;
        size = 1;

    }
    public int getRotaion() {
        return rotaion;
    }

    public int getSize() {
        return size;
    }

    public void setRotaion(int rotaion) {
        this.rotaion = rotaion;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void addSize(){
        size++;
    }
}
