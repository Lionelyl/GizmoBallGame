package gizmogame.model.gizmos;

import gizmogame.model.Collision;
import gizmogame.model.Components;
import gizmogame.physics.Vect;

public class Absorber extends Components {

    private int rotaion;

    public Absorber(Vect origin, String name) {
        super(origin, name);
        rotaion = 0;
    }

    @Override
    public void handle(Collision collision) {

    }
}
