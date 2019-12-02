package gizmogame.model;

import gizmogame.physics.Circle;
import gizmogame.physics.Vect;

public class Ball extends Components{

    private int size;
    private boolean absorbed;
    private Circle physicsCircle;
    private Vect center;
    private Vect velocity;
    private int diameter;
    public final static double moveTime = 0.05;
    private int vx = 0;
    private int vy = 0;
    private Vect gravity = new Vect(0,0);




    public Ball(Vect origin, String name){

        super(origin,name);
        size = 1;
        absorbed = false;
        center = origin.plus((new Vect((bound.x() - origin.x())/2,(bound.y()-origin.y())/2)));
        velocity = new Vect(0,10);
        diameter = (int)(bound.x()-origin.x());
        physicsCircle = new Circle(center, 0.25);
        vx = (int)velocity.x();
        vy = (int)velocity.y();
    }

    public void moveForTime(double time){
        if (!absorbed) {
            boolean nearBoardBound = false;
            Vect changeAmount = velocity.times(time);

           // System.out.println(center);
            //System.out.println(changeAmount);

            Vect newCenter = center.plus(changeAmount);

           // System.out.println(newCenter);

            setCenter(newCenter);
            setOrigin(center.minus(new Vect(diameter/2,diameter/2)));



            int x = (int)newCenter.x();
            int y = (int)newCenter.y();

           // System.out.println(x + " " + y);
            vy = (int)velocity.y();
            vx = (int)velocity.x();

            if (x <= diameter/2+10) {
                x = diameter/2+10 + 1;
                vx = -vx;
                nearBoardBound = true;
            }
            if (x >= 810 - diameter/2) {
                x = 810 - diameter/2;
                vx = -vx;
                nearBoardBound = true;
            }

            if (y <= diameter/2+10) {
                y = diameter/2+10+1;
                vy = -vy;
                nearBoardBound = true;
            }
            if (y >= 810 - diameter/2) {
                y =  810 - diameter/2;
                vy = -vy;
                nearBoardBound = true;
            }

            if(nearBoardBound) {
                velocity = new Vect(vx, vy);
                setCenter(new Vect(x, y));
                setOrigin(center.minus(new Vect(diameter / 2, diameter / 2)));
            }
            setBound(center.plus(new Vect(diameter/2,diameter/2)));
            setDiameter(origin,bound);
            physicsCircle = new Circle(origin,0.25);
            //System.out.println(center);

        }
    }

    public void move(){

        int x = (int)center.x();
        int y = (int)center.y();

        vy = (int)velocity.plus(gravity).y();
        vx = (int)velocity.x();

        System.out.println(vy);

        x += vx;
        if (x <= diameter/2+10) {
            x = diameter/2+10;
            vx = -vx;
        }
        if (x >= 810 - diameter/2) {
            x = 810 - diameter/2;
            vx = -vx;
        }


        y += vy;
        if (y <= diameter/2+10) {
            y = diameter/2+10;
            vy = -vy;
        }
        if (y >= 810 - diameter/2) {
            y =  810 - diameter/2;
            vy = -vy;
        }

        velocity = new Vect(vx,vy);
        setCenter(new Vect(x,y));
        setOrigin(center.minus(new Vect(diameter/2,diameter/2)));
        setBound(center.plus(new Vect(diameter/2,diameter/2)));
        setDiameter(origin,bound);

    }


    public boolean inside(Components otherElement) {
        Vect ourOrigin = origin, ourBound = getBound(), theirOrigin = otherElement.getOrigin(),
                theirBound = otherElement.getBound();

        boolean topIn = ourOrigin.y() <= theirBound.y() && ourOrigin.y() >= theirOrigin.y();
        boolean bottomIn = ourBound.y() >= theirOrigin.y() && ourBound.y() <= theirBound.y();
        boolean leftIn = ourOrigin.x() <= theirBound.x() && ourOrigin.x() >= theirOrigin.x();
        boolean rightIn = ourBound.x() >= theirOrigin.x() && ourBound.x() <= theirBound.x();

        // still with me?

        boolean verticallyIn = leftIn && rightIn;
        boolean horizontallyIn = topIn && bottomIn;

        return (verticallyIn && (topIn || bottomIn)) || (horizontallyIn && (leftIn || rightIn));
    }




    public Vect getOrigin() {
        return origin;
    }

    public String getName() {
        return name;
    }

    public Circle getCircle() {
        return physicsCircle;
    }

    public Vect getCenter() {
        return center;
    }

    public Vect getVelocity() {
        return velocity;
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

    public void setDiameter(Vect origin, Vect bound) {
        this.diameter = (int)(bound.x()-origin.x());
    }

    @Override
    public void handle(Collision c) {
        Ball ball = c.getBall();
        ball.moveForTime(c.getTime());
        ball.setVelocity(c.getVelocity());
    }
}
