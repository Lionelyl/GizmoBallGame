package gizmogame.view;

import gizmogame.controller.BoardMouseListener;

import gizmogame.controller.ModelListener;
import gizmogame.model.Ball;
import gizmogame.model.Board;
import gizmogame.model.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardView extends JPanel {
    private static int FRAMES_PER_SECOND = 100;
    private int ox = 10;
    private int oy = 10;
    private int ex = 810;
    private int ey = 810;

    private Board board;
    private String componentType;
    private Timer timer;

    public BoardView( Board board) {
        super();
        this.board = board;
        componentType = "select";
        setPreferredSize(new Dimension(820, 840));
        addMouseListener(new BoardMouseListener(this,board));
        timer = new Timer(1000/FRAMES_PER_SECOND,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("get ball");
                Ball ball = board.getBall();
                ball.move();
                updateUI();
                //System.out.println("update");

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawRect(g);
        drawLine(g);
        for (Components c : board.getComponents()) {
            c.draw(g);
        }
    }

    private void drawLine(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.white);

        int x, y;
        int d = 40;
        int xBound = 20 * d + ox;
        int yBound = 20 * d + oy;

        for (x = ox; x <= xBound; x += d) {
            g2d.drawLine(x, oy, x, yBound);
        }
        for (y = oy; y <= xBound; y += d) {
            g2d.drawLine(ox, y, xBound, y);
        }

        g2d.dispose();
    }

    private void drawRect(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
        g2d.fillRect(ox, oy, 800, 800);

        g2d.dispose();
    }

    public int getOx() {
        return ox;
    }

    public int getOy() {
        return oy;
    }

    public int getEx() {
        return ex;
    }

    public int getEy() {
        return ey;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getComponentType() {
        return componentType;
    }

    public Timer getTimer() {
        return timer;
    }
    /*    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(820, 840);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoardView BoardView = new BoardView();
        frame.add(BoardView);
    }*/
}
