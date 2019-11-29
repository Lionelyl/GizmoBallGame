package gizmogame.view;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class JFileMenu extends JMenuBar {


    public JFileMenu(){

        add(createFileMenu());
        setVisible(true);
    }

    private JMenu createFileMenu(){

        JMenu menu = new JMenu("文件(F)");

        menu.setMnemonic(KeyEvent.VK_F);
        JMenuItem item = new JMenuItem("新建游戏(N)",KeyEvent.VK_N);
        //item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menu.add(item);
        item = new JMenuItem("保存游戏(S)",KeyEvent.VK_S);
        menu.add(item);
        item = new JMenuItem("读取游戏(L)");
        menu.add(item);

        return menu;
    }
/*
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setSize(300,200);
        frame.setJMenuBar(new JFileMenu());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
