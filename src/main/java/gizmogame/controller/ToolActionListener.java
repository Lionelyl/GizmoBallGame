package gizmogame.controller;

import gizmogame.model.Board;
import gizmogame.model.Components;
import gizmogame.view.BoardView;
import gizmogame.view.Ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolActionListener implements ActionListener {


    private BoardView boardView;
    private Board board;

    public ToolActionListener(BoardView boardView, Board board) {
        this.boardView = boardView;
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand().toLowerCase();
        switch (cmd) {
            case "rotate":
                System.out.println("rotate");
                if(board.getSelectedComponent().canRotate())
                    board.getSelectedComponent().rotate();
                boardView.updateUI();
                break;
            case "zoombig":
                board.getSelectedComponent().zoomBig(board);
                boardView.updateUI();
                break;
            case "zoomsmall":
                board.getSelectedComponent().zoomSmall();
                boardView.updateUI();
                break;
            case "delete":
                Components c = board.getSelectedComponent();
                board.getComponents().remove(c);
                boardView.updateUI();
                break;
            default:
                break;
        }
    }
}
