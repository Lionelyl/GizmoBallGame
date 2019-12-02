package gizmogame.model.gizmos;

import gizmogame.model.Ball;
import gizmogame.model.Board;
import gizmogame.model.Collision;
import gizmogame.model.Components;
import gizmogame.physics.LineSegment;
import gizmogame.physics.Vect;
import gizmogame.view.Ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square extends Components {

    private int rotaion;
    private int size;
    private List<Vect> coordinates = new ArrayList<>();

    public Square(Vect origin,String name){
        super(origin,name);
        coordinates = calculateCoordinates();
        super.setCircles(calculateCircles());
        super.setLines(calculateLines());
        rotaion = 0;
        size = 1;
    }


    private List<Vect> calculateCoordinates() {
        Vect topLeft = origin;
        Vect topRight = new Vect(bound.x(), origin.y());
        Vect bottomRight = bound;
        Vect bottomLeft = new Vect(origin.x(), bound.y());
        return Arrays.asList(topLeft, topRight, bottomRight, bottomLeft);
    }

    /**
     * Calculate this Element's circles.
     *
     * @return this Element's circles.
     */
    private List<gizmogame.physics.Circle> calculateCircles() {
        List<gizmogame.physics.Circle> calcCircles = new ArrayList<>();
        for (Vect coord : coordinates) {
            gizmogame.physics.Circle circle = new gizmogame.physics.Circle(coord, 0);
            calcCircles.add(circle);
        }
        return calcCircles;
    }

    /**
     * Calculate this Element's lines.
     *
     * @return this Element's lines.
     */
    private List<LineSegment> calculateLines() {
        List<LineSegment> calcLines = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            Vect a = coordinates.get(i);
            Vect b = coordinates.get((i + 1) % coordinates.size());
            LineSegment line = new LineSegment(a, b);
            calcLines.add(line);
        }
        return calcLines;
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

    @Override
    public void handle(Collision c) {
        Ball ball = c.getBall();
        ball.moveForTime(c.getTime());
        ball.setVelocity(c.getVelocity());
    }
}
