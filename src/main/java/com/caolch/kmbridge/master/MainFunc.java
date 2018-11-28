package com.caolch.kmbridge.master;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class MainFunc {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        final JFrame km = new KMFrame();

        try {
            /**
             * 在主线程建frame会报异常，详细解决方案见如下链接：
             * "https://stackoverflow.com/questions/27807079/"+
             * "exception-in-thread-awt-eventqueue-0-java-lang-classcastexception-in-my-jframe"
             */
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    ((KMFrame) km).initFrame();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
