package gizmogame.controller;

import gizmogame.model.Ball;
import gizmogame.model.Board;
import gizmogame.model.ComponentBuilder;
import gizmogame.model.Components;
import gizmogame.physics.Vect;
import gizmogame.view.BoardView;
import gizmogame.view.Ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener {
    private Board board;
    private BoardView boardView;
    private ComponentBuilder componentBuilder;

    public BoardMouseListener(BoardView boardView, Board board) {
        this.boardView = boardView;
        this.board = board;
        componentBuilder = new ComponentBuilder();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("鼠标点击");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getPoint());

        int cx = ((e.getX() - boardView.getOx()) / 40) * 40 + 10;
        int cy = ((e.getY() - boardView.getOy()) / 40) * 40 + 10;

       if(boardView.getComponentType().equals("select")){

           board.setSelectedComponent(board.getClickPointComponent(new Vect(e.getX(),e.getY())));
           System.out.println(board.getSelectedComponent());
       }
       else
       {
           if(board.getClickPointComponent(new Vect(cx,cy)) == null){
               Components c = componentBuilder.createComponet(boardView.getComponentType(),new Vect(cx,cy));
               board.getComponents().add(c);
               board.setSelectedComponent(c);
               if(c instanceof Ball)
                   board.setBall((Ball)c);
               boardView.updateUI();
           }

       }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // System.out.println("鼠标释放");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("鼠标进入组件区域");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // System.out.println("鼠标离开组件区域");
    }
}
