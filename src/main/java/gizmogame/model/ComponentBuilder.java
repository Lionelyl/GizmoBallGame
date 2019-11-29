package gizmogame.model;

import gizmogame.model.gizmos.*;
import gizmogame.physics.Vect;

public class ComponentBuilder {

    public Components createComponet(String name, Vect origin) {
        switch (name) {
            case "ball":
                return createBall(origin);
            case "circle":
                return createCircle(origin);
            case "square":
                return createSquare(origin);
            case "triangle":
                return createTriangle(origin);
            case "absorber":
                return createAbsorber(origin);
            case "pipe1":
                return createPipe1(origin);
            case "pipe2":
                return createPipe2(origin);
            case "lflipper":
                return createLFlipper(origin);
            case "rflipper":
                return createRFlipper(origin);
            default:
                return null;

        }
    }

    private Components createCircle(Vect origin){
        String name = "circle" ;
        Components c =  new Circle(origin,name);
        c.index =Components.count;
        return c;
    }
    private Components createTriangle(Vect origin){
        String name = "triangle";
        Components c = new Triangle(origin,name);
        c.index =Components.count;
        return c;
    }
    private Components createSquare(Vect origin){
        String name = "square";
        Components c = new Square(origin,name);
        c.index =Components.count;
        return c;
    }
    private Components createAbsorber(Vect origin){
        String name = "absorber";
        Components c = new Absorber(origin,name);
        c.index =Components.count;
        return c;
    }
    private Components createPipe1(Vect origin){
        String name = "pipe1" ;
        Components c = new StraightPipe(origin,name);
        c.index =Components.count;
        return c;
    }
    private Components createPipe2(Vect origin){
        String name = "pipe2" ;
        Components c = new CurvePipe(origin,name);
        c.index =Components.count;
        return c;
    }
    private Components createLFlipper(Vect origin){
        String name = "lflipper" ;
        Components c = new Flipper(origin,name);
        c.index =Components.count;
        return c;
    }
    private Components createRFlipper(Vect origin){
        String name = "rflipper" ;
        Components c = new Flipper(origin,name);
        c.index = Components.count;
        return c;
    }
    private Components createBall(Vect origin){
        String name = "ball";
        Components c = new Ball(origin,name);
        c.index = Components.count;
        return c;
    }
}
