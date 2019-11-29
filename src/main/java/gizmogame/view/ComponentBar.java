package gizmogame.view;


import gizmogame.controller.ComponentActionlistener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class ComponentBar extends JPanel {


    static final private String SELECT="SELECT";
    static final private String BALL="BALL";
    static final private String ABSORBER="ABSORBER";
    static final private String SQUARE="SQUARE";
    static final private String CIRCLE="CIRCLE";
    static final private String TRIANGLE="TRIANGLE";
    static final private String PIPE1="PIPE1";
    static final private String PIPE2="PIPE2";
    static final private String LFLIPPER="LFLIPPER";
    static final private String RFLIPPER="RFLIPPER";

    private BoardView boardView;
    private ActionListener componentActionlistener;

    public ComponentBar(BoardView boardView){
        super(new GridLayout(5,2,10,10));
        this.boardView = boardView;
        this.componentActionlistener = new ComponentActionlistener(this.boardView);
        setBackground(Color.white);
        addButtions();

    }

    public void addButtions(){

        ButtonGroup btngroup = new ButtonGroup();


        Box box1 = makeNavigationButtionBox("select",SELECT,"select a component",btngroup);

        Box box2 = makeNavigationButtionBox("ball",BALL, "add a ball",btngroup);

        Box box3 = makeNavigationButtionBox("absorber",ABSORBER, "add a absorber",btngroup);

        Box box4 = makeNavigationButtionBox("triangle",TRIANGLE, "add a triangle",btngroup);

        Box box5 = makeNavigationButtionBox("circle",CIRCLE, "add a circle",btngroup);

        Box box6 = makeNavigationButtionBox("square",SQUARE, "add a square",btngroup);

        Box box7 = makeNavigationButtionBox("pipe1",PIPE1, "add a straight pipe",btngroup);

        Box box8 = makeNavigationButtionBox("pipe2",PIPE2, "add a curve pipe",btngroup);

        Box box9 = makeNavigationButtionBox("lflipper",LFLIPPER, "add a lflipper",btngroup);

        Box box10 = makeNavigationButtionBox("rflipper",RFLIPPER, "add a rflipper",btngroup);

        add(box1);
        add(box2);
        add(box3);
        add(box4);
        add(box5);
        add(box6);
        add(box7);
        add(box8);
        add(box9);
        add(box10);

    }

    public Box makeNavigationButtionBox(String imageName, String actionCommand, String toolTipText, ButtonGroup btg){

        Box box = Box.createHorizontalBox();

        JLabel label = new JLabel();

        label.setIcon(new ImageIcon("src/main/resources/"+imageName+".png"));
        JRadioButton button = new JRadioButton();
        btg.add(button);
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(componentActionlistener);

        box.add(button);
        box.add(Box.createHorizontalGlue());
        box.add(label);
        box.add(Box.createHorizontalGlue());
        return box;
    }
}
