package com.caolch.kmbridge.Utils;

import com.caolch.kmbridge.common.Resolution;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScreenUtil {

    /**
     * 获取屏幕分辨率.
     * @return
     */
    public static List<Resolution> getResolutions() {
        List<Resolution> rls = new ArrayList<Resolution>();
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = g.getScreenDevices();

        for (int i = 0; i < devices.length; i++) {
            Resolution rl = new Resolution();
            rl.setHeight(devices[i].getDisplayMode().getHeight());
            rl.setWidth(devices[i].getDisplayMode().getWidth());
            rls.add(rl);
            System.out.println("Width:" + devices[i].getDisplayMode().getWidth());
            System.out.println("Height:" + devices[i].getDisplayMode().getHeight());
        }
        return rls;
    }
}
