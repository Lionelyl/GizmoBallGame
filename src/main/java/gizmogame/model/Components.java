package gizmogame.model;

import gizmogame.physics.Circle;
import gizmogame.physics.LineSegment;
import gizmogame.physics.Vect;
import gizmogame.view.BoardView;
import gizmogame.view.Ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

abstract public class Components {

    protected static int count = 0;
    protected int index = 0;
    protected Vect origin, bound;
    protected String name;
    protected Collection<Triggerable> triggerables;
    protected Image image;
    protected int size,rotation;

    private List<Circle> circles = new ArrayList<>();
    private List<LineSegment> lines = new ArrayList<>();
    private List<Vect> coordinates = new ArrayList<>();



    public Components(Vect origin, String name) {
        this.origin = origin;
        setBound(origin.plus(new Vect(Ui.dis, Ui.dis)));
        coordinates = calculateCoordinates();
        circles = calculateCircles();
        lines = calculateLines();
        this.name = name;
        size = 1;
        count++;
        image = getImage();
        rotation = 0;

    }

    public Vect getOrigin() {
        return origin;
    }

    public Vect getBound() {
        return bound;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setOrigin(Vect origin) {
        this.origin = origin;
    }

    public void setBound(Vect bound) {
        this.bound = bound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setCircles(List<Circle> circles) {

        this.circles = circles;
    }

    public void setLines(List<LineSegment> lines) {
        this.lines = lines;
    }

    private List<Vect> calculateCoordinates() {
        Vect topLeft = origin;
        Vect topRight = new Vect(bound.x(), origin.y());
        Vect bottomLeft = new Vect(origin.x(), bound.y());
        return Arrays.asList(topLeft, topRight, bottomLeft);
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



    /**
     * Get this Triangle's center point.
     * @return
     */
    public Vect getCenterPoint() {
        double width = bound.x() - origin.x();
        double height = bound.y() - origin.y();
        return origin.plus(new Vect(width / 2, height / 2));
    }
    public void rotate(BoardView boardView) {
        Vect centerPoint = getCenterPoint();
        rotation =( (rotation + 1) % 4);
        //setSaveInfo();
        for (int i = 0; i < coordinates.size(); i++) {
            coordinates.set(i, rotationMatrix(coordinates.get(i), centerPoint));
        }
        setCircles(calculateCircles());
        setLines(calculateLines());
        boardView.updateUI();
    }

    /**
     * ZoomBig a gizmo
     */
    public void zoomBig(Board board) {
        size++;
        if (judgeLocated(board)) {
            bound = calculateBound();
            size --;
            if (bound.x() <= 20 * Ui.dis + 10 && bound.y() <= 20 * Ui.dis + 10){
                size++;
                System.out.println("big");
            }
        } else {
            size--;
            bound = calculateBound();
        }
    }


    /**
     * ZoomSmall a gizmo
     */
    public void zoomSmall() {
        if(size > 1) {
            size --;
            bound = calculateBound();
        }
    }


    public Vect calculateBound() {
        Vect bound = origin.plus(new Vect(Ui.dis * size, Ui.dis * size));
        return bound;
    }

    public boolean judgeLocated(Board board) {

        Vect topRight = origin.plus(new Vect(Ui.dis * (size-1),0));
        Vect bottomLeft = origin.plus(new Vect(0,Ui.dis * (size-1)));
        Vect bottomRight = origin.plus(new Vect(Ui.dis * (size-1),Ui.dis * (size-1)));

        for(int y = (int)topRight.y(); y <= bottomRight.y(); y += Ui.dis){

            Vect v = new Vect(topRight.x(),y);
            System.out.println(y);
            if(board.getClickPointComponent(v)!=null){
               // System.out.println("1");
                return false;
            }

        }
        for(int x = (int)bottomLeft.x(); x < bottomRight.x(); x += Ui.dis){
            Vect v = new Vect(x,bottomLeft.y());
            if(board.getClickPointComponent(v)!=null){
               // System.out.println("2");
                return false;
            }

        }
        return true;
    }

    /**
     * Draw a gizmo
     */
    public void draw(Graphics g) {
        g.drawImage(image, (int) origin.x(), (int) origin.y(), size * Ui.dis, size * Ui.dis, null);

    }

    /**
     * ZoomSmall a gizmo
     */
    public Image getImage() {

        Image image = new ImageIcon("src/main/resources/hd/" + getName() + ".png").getImage();
        return image;
    }

    public Vect getCenter() {
        return null;
    }


    /**
     * Rotate a coordinate around the center point by 90°.
     *
     * @param coordinate
     * @param center
     * @return
     */
    protected Vect rotationMatrix(Vect coordinate, Vect center) {
        double angleR = Math.toRadians((double) 90);
        Vect coord = coordinate.minus(center);
        double newX = coord.x() * Math.cos(angleR) - coord.y() * Math.sin(angleR);
        double newY = coord.x() * Math.sin(angleR) + coord.y() * Math.cos(angleR);
        return new Vect(newX, newY).plus(center);
    }
}
