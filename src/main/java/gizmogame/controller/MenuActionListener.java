package gizmogame.controller;

import gizmogame.view.JFileMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MenuActionListener {
    private JFileMenu jFileMenu;
    private JMenuItem jMenuItemSave;
    private JMenuItem jMenuItemCreate;
    private File file;
    private JTextArea jTextArea;

    public MenuActionListener(JFileMenu jFileMenu){
        this.jFileMenu = jFileMenu;
    }

    public void actionPerformerd(ActionEvent e){
        String cmd = e.getActionCommand().toLowerCase();
        switch (cmd){
            case "create":
                break;
            case "save":
                break;
            case "load":
                break;
        }
    }

}
