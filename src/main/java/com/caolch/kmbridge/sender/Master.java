package com.caolch.kmbridge.sender;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.lang.reflect.InvocationTargetException;

public class Master {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        final KeyAdapter keyListener = new KeyEventListener();
        final JFrame km = new KMFrame();

        try {
            /**
             * 在主线程建frame会报异常，详细解决方案见如下链接：
             * "https://stackoverflow.com/questions/27807079/"+
             * "exception-in-thread-awt-eventqueue-0-java-lang-classcastexception-in-my-jframe"
             */
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    ((KMFrame) km).initFrame(keyListener);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
