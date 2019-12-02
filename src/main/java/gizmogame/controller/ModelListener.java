package gizmogame.controller;

import gizmogame.model.Board;
import gizmogame.view.BoardView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ModelListener implements ActionListener {

    private BoardView boardView;
    private Board board;
    private Timer timer;

    public ModelListener(BoardView boardView, Board board) {
        this.boardView = boardView;
        this.board = board;
        timer = new javax.swing.Timer(1, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {

            //System.out.println("get timer");
            board.tick();
            boardView.updateUI();
        } else {
            System.out.println(e.getActionCommand());
            if (e.getActionCommand().equals("PLAY")) {
                //boardView.getTimer().start();
               // System.out.println("timer start");
                timer.start();
            } else {
                //boardView.getTimer().stop();
                //System.out.println("timer stop");
                timer.stop();
            }

        }
    }
}
