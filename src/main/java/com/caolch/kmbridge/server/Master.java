package com.caolch.kmbridge.server;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.lang.reflect.InvocationTargetException;

public class Master {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        KeyAdapter keyListener = new KeyEventListener();
        JFrame km = new KMFrame(keyListener);
    }
}
