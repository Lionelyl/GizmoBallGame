package gizmogame.model;

import gizmogame.physics.Circle;
import gizmogame.physics.Geometry;
import gizmogame.physics.LineSegment;
import gizmogame.physics.Vect;

import java.util.ArrayList;
import java.util.Collection;

public class Board {

    private Collection<Components> components;
    private Ball ball;
    private Components selectedComponent;
    private Vect mousePress;
    private Collision closestCollision;
    public final static double moveTime = 0.05;

    public Board(){
        components = new ArrayList<>();
        selectedComponent = null;
    }

    public Components getClickPointComponent(Vect mousePress){


        if(ball != null && ball.getOrigin().x() <= mousePress.x() && ball.getBound().x() > mousePress.x())
            if(ball.getOrigin().y() <= mousePress.y() && ball.getBound().y() >mousePress.y())
                return ball;

        for(Components c :components){
            Vect origin = c.getOrigin();
            Vect bound = c.getBound();

            if(origin.x() <= mousePress.x() && bound.x() > mousePress.x()){
                if(origin.y() <= mousePress.y() && bound.y() > mousePress.y()){
                    return c;
                }
            }
        }
        return null;
    }


    public Collection<Components> getComponents() {
        return components;
    }

    public Components getSelectedComponent() {
        return selectedComponent;
    }

    public Vect getMousePress() {
        return mousePress;
    }

    public Ball getBall() {
        return ball;
    }

    public void setComponents(Collection<Components> components) {
        this.components = components;
    }

    public void setSelectedComponent(Components selectedComponent) {
        this.selectedComponent = selectedComponent;
    }

    public void setMousePress(Vect mousePress) {
        this.mousePress = mousePress;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }


    /**
     * Get the time until this ball will have its next collision.
     *
     * @param ball
     * @return
     */
    public Collision getTimeTillCollision(Ball ball) {
        closestCollision = new Collision(0, 0, Double.MAX_VALUE);
        for (Components element : getComponents()) {
            /*if (element instanceof Absorber && ball.inside(element))
                continue;*/

            System.out.println(element);

            int i =0;
            for (Circle circle : element.getCircles()) {
                System.out.println(++i);
               // System.out.println(element.getCircles());
                detectCircleCollision(circle, ball, element);
            }

            for (LineSegment line : element.getLines()) {
                //System.out.println(element.getLines());
                detectLineCollision(line, ball, element);
            }

            /*if (element instanceof Flipper) {

                //((Flipper) element).flip();

                for (LineSegment line : element.getLines()) {
                    detectFlipperCollision(line, ball, element);
                }

            }*/

        }
        /*for (Ball otherBall : getBalls()) {
            detectBallCollision(otherBall, ball);
        }*/
        return closestCollision;
    }


    /**
     * Detect the time until the next collision between the circle and ball.
     *
     * @param circle
     * @param ball
     * @param element
     */
    private void detectCircleCollision(Circle circle, Ball ball, Components element) {
        double time = Geometry.timeUntilCircleCollision(circle, ball.getCircle(), ball.getVelocity());
        System.out.println("circle:  "+circle);
        System.out.println("ball.getCircle:  "+ball.getCircle());
        System.out.println("ball.getVelocity:  "+ball.getVelocity());
        System.out.println("time:  " +time);
        if (time < closestCollision.getTime()) {
            Vect newV = Geometry.reflectCircle(circle.getCenter(), ball.getCenter(), ball.getVelocity());
            closestCollision = new Collision(newV, time, element, ball);
        }
    }

    /**
     * Detect the time until the next collision between the line and ball.
     *
     * @param line
     * @param ball
     * @param element
     */
    private void detectLineCollision(LineSegment line, Ball ball, Components element) {
        double time = Geometry.timeUntilWallCollision(line, ball.getCircle(), ball.getVelocity());
        if (time < closestCollision.getTime()) {
            Vect newV = Geometry.reflectWall(line, ball.getVelocity());
            closestCollision = new Collision(newV, time, element, ball);
        }
    }


    /**
     * move the ball ball for one tick
     *
     * @param ball
     * @return
     */
    private Ball moveBall(Ball ball) {
        Collision collision = getTimeTillCollision(ball);

        System.out.println(collision.getTime() + " "+ moveTime);

        if (collision.getTime() >= moveTime) { // No Collision
            ball.moveForTime(moveTime);
        } else { // Collision
            ball.moveForTime(collision.getTime());
            collision.getHandler().handle(collision);
        }
        return ball;
    }

    public void tick() {

        /*for (IElement element : getElements()) {
            if (element instanceof Flipper) {
                ((Flipper) element).flip();
            }
        }*/
        /*Collection<Ball> newBalls = new ArrayList<>();
        for (Ball ball : getBalls()) {
            newBalls.add(moveBall(ball));
        }*/

        //setBalls(newBalls);
        Ball newBall = moveBall(ball);
        setBall(newBall);

    }
}
