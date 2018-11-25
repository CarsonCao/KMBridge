package com.clc.test;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;

public class Main {
    public static JComponent makeUI() {
        JPanel p = new JPanel();
        p.setBackground(new Color(.5f, .5f, .5f, .5f));
//        p.add(new JComboBox<String>(new String[] { "aaa", "bb", "c" }));
//        JComboBox c = new JComboBox<String>(new String[] { "aaa", "bb", "c" });
//        p.add(c);
        return p;
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame f = new JFrame();
        f.setBackground(new Color(0, true)); // 1.7.0
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(makeUI());
        f.setSize(320, 240);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
