package com.caolch.kmbridge.master;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class KMFrame extends JFrame {

    public void initFrame(KeyAdapter listener){

        int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(1200, 800);//设置Frame的大小
        this.setLocation((screenWidth-1200)/2, (screenHeight-800)/2);//设置Frame显示在屏幕中央

        this.setBackground(new Color(0, true));
        this.getContentPane().add(MainPanel());

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("KMBridge");
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
