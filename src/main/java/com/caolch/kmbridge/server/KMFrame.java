package com.caolch.kmbridge.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.lang.reflect.InvocationTargetException;

public class KMFrame extends JFrame {

    public KMFrame(KeyAdapter listener){

        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(800, 450);//设置Frame的大小
        this.setLocation((screenWidth-800), (screenHeight-450));//设置Frame显示在屏幕中央

        this.setBackground(new Color(0, true));
        this.getContentPane().add(MainPanel());

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("my jframe");
        this.setVisible(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.addKeyListener(listener);
    }

    public static JComponent MainPanel() {
        JPanel p = new JPanel();
        p.setBackground(new Color(.5f, .5f, .5f, .4f));
        return p;
    }
}
