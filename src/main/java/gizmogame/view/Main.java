package gizmogame.view;

import gizmogame.model.Board;
import gizmogame.physics.LineSegment;
import gizmogame.physics.Vect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
     public static void main(String[] args) {
         Board board = new Board();
         Ui ui = new Ui(board);
    }

  /*  private Vect origin = new Vect(0,0);
    private Vect  bound = new Vect(10,10);
    private List<Vect> list = new ArrayList<>();


    private List<Vect> calculateCoordinates() {
        Vect topLeft = origin;
        Vect topRight = new Vect(bound.x(), origin.y());
        Vect bottomRight = bound;
        Vect bottomLeft = new Vect(origin.x(), bound.y());
        return Arrays.asList(topLeft, topRight, bottomRight, bottomLeft);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.list = main.calculateCoordinates();
        Vect a = main.list.get(1);
        Vect b = main.list.get(2 % main.list.size());
        LineSegment lineSegment = new LineSegment(a,b);
        System.out.println(a.toString()+ "  " + b.toString() +"  " +lineSegment.toString());
    }*/
}
