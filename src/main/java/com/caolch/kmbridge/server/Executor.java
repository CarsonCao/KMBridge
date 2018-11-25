package com.caolch.kmbridge.server;

import javax.swing.*;
import java.awt.event.KeyAdapter;

public class Executor {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        KeyAdapter keyListener = new KeyEventListener();
        JFrame km = new KMFrame(keyListener);
    }
}
