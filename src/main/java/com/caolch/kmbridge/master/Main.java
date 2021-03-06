package com.caolch.kmbridge.master;

import com.caolch.kmbridge.common.ParamsManager;
import com.caolch.kmbridge.common.RunningType;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        //Init frame
        JFrame.setDefaultLookAndFeelDecorated(true);
        final JFrame km = new KMFrame();
        //Init params
        ParamsManager.getOrCreate(RunningType.MASTER).load(args);
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
