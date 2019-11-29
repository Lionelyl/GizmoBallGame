package gizmogame.controller;

import gizmogame.view.BoardView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentActionlistener implements ActionListener {


    private BoardView boardView;

    public ComponentActionlistener(BoardView boardView){
        this.boardView = boardView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand().toLowerCase());
        boardView.setComponentType(e.getActionCommand().toLowerCase());
    }
}
