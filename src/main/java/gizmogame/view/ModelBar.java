package gizmogame.view;

import gizmogame.controller.ModelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Font.SANS_SERIF;

public class ModelBar extends JPanel {

    static final private String PLAY = "PLAY";
    static final private String BUILD = "BUILD";

    private BoardView boardView;
    private ActionListener modelListener;

    public ModelBar(BoardView boardView) {
        super(new GridLayout(2, 1));
        this.boardView = boardView;
        modelListener = new ModelListener(boardView);

        JLabel label1 = new JLabel("GIZMO BALL", JLabel.CENTER);
        label1.setFont(new Font(SANS_SERIF, Font.BOLD, 20));
        setBackground(Color.white);

        JButton playButtion = makeNavigationButtion(PLAY, "paly a game", "游玩模式");
        JButton buildButton = makeNavigationButtion(BUILD, "build a game", "布局模式");

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridLayout(2, 1, 10, 30));
        panel.add(buildButton);
        panel.add(playButtion);
        add(panel);
        add(new JPanel().add(label1));
    }

    public JButton makeNavigationButtion(String actionCommand, String toolTipText, String altText) {
        JButton button = new JButton();

        button.setText(altText);
        button.setToolTipText(toolTipText);
        button.setActionCommand(actionCommand);
        button.addActionListener(modelListener);
        return button;

/*
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400,300);
        frame.add(new ModelBar());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }*/
    }
}