package gizmogame.controller;

import gizmogame.view.BoardView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class ModelListener implements ActionListener {

    private BoardView boardView;

    public ModelListener(BoardView boardView) {
        this.boardView = boardView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("PLAY")){
           // boardView.getTimer().start();
            //System.out.println("timer start");
        }
        else{
           // boardView.getTimer().stop();
            //System.out.println("timer stop");
        }

    }
}
