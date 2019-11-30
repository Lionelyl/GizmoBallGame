package gizmogame.model;

import gizmogame.physics.Vect;

import java.util.ArrayList;
import java.util.Collection;

public class Board {

    private Collection<Components> components;
    private Ball ball;
    private Components selectedComponent;
    private Vect mousePress;

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

}
