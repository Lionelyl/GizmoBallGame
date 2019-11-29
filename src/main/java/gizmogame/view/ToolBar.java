package gizmogame.view;

import gizmogame.controller.ToolActionListener;
import gizmogame.model.Ball;
import gizmogame.model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel{

    static final private String ZOOMBIG="ZoomBig";
    static final private String ZOOMSMALL="ZoomSmall";
    static final private String ROTATE="Rotate";
    static final private String DELETE="Delete";

    private Board board;
    private BoardView boardView;
    private ActionListener actionListener;

    public ToolBar(BoardView boardView, Board board){

        super(new GridLayout(2,1,10,10));
        this.board = board;
        this.boardView = boardView;
        setBackground(Color.white);
        actionListener = new ToolActionListener(boardView,board);
        addButtions();
    }

    public void addButtions(){
        JButton button = null;
        setLayout(new GridLayout(2,2));
        button = makeNavigationButtion("zoombig",ZOOMBIG,"放大","ZoomBig");
        add(button);

        button = makeNavigationButtion("zoomsmall",ZOOMSMALL,"缩小","ZoomSmall");
        add(button);

        button = makeNavigationButtion("rotate",ROTATE,"旋转","Rotate");
        add(button);

        button = makeNavigationButtion("delete",DELETE,"删除","Delete");
        add(button);
    }

    public JButton makeNavigationButtion(String imageName, String actionCommand, String toolTipText, String altText){


        JButton button = new JButton();
        button.setIcon(new ImageIcon("src/main/resources/"+imageName +".jpg"));

        button.setActionCommand(actionCommand);

        button.setToolTipText(toolTipText);
        button.addActionListener(actionListener);
        return button;
    }

/*
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");

        JPanel jPanel = new JPanel();
        JTextArea textArea = new JTextArea(15,30);
        jPanel.add(textArea);
        frame.setSize(800,600);
        //frame.pack();
        frame.setJMenuBar(new JFileMenu());

        frame.add(new ToolBar());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
