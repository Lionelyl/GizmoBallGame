package gizmogame.view;

import gizmogame.controller.ToolActionListener;
import gizmogame.model.Board;

import javax.swing.*;
import java.awt.*;

public class Ui extends JFrame{
    public static final int dis = 40;

    private Board board;
    private BoardView boardView;
    private ComponentBar componentBar;
    private ModelBar modelBar;
    private ToolBar toolBar;

        public Ui(Board board){
            this.board = board;
            boardView = new BoardView(board);
            componentBar = new ComponentBar(boardView);
            toolBar = new ToolBar(boardView,board);
            modelBar = new ModelBar(boardView,board);

            createUI();
        }

        private void createUI(){
            JLabel l0 = new JLabel("组件栏",JLabel.CENTER);
            JLabel l1 = new JLabel("工具栏");
            JLabel l2 = new JLabel("模式栏",JLabel.CENTER);

            Box vBox = Box.createVerticalBox();
            vBox.setPreferredSize(new Dimension(275,855));

            Box componentBox = Box.createHorizontalBox();
            componentBox.add(Box.createHorizontalGlue());
            componentBox.add(l0);
            componentBox.add(Box.createHorizontalGlue());

            Box toolBox = Box.createHorizontalBox();
            toolBox.add(Box.createHorizontalGlue());
            toolBox.add(l1);
            toolBox.add(Box.createHorizontalGlue());

            Box modelBox = Box.createHorizontalBox();
            modelBox.add(Box.createHorizontalGlue());
            modelBox.add(l2);
            modelBox.add(Box.createHorizontalGlue());

            vBox.add(componentBox);
            vBox.add(componentBar);
            vBox.add(toolBox);
            vBox.add(toolBar);
            vBox.add(modelBox);
            vBox.add(modelBar);

            Box uiBox = Box.createHorizontalBox();
            uiBox.add(boardView);
            uiBox.add(vBox);
            add(uiBox);
            setJMenuBar(new JFileMenu());
            setSize(1100,860);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }


      /*  public static void main(String[] args) {
         Ui ui = new Ui();
        }*/
}

