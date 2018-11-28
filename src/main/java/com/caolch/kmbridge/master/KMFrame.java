package com.caolch.kmbridge.master;

import com.caolch.kmbridge.Utils.Resolution;
import com.caolch.kmbridge.Utils.ScreenUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.List;

public class KMFrame extends JFrame {

    public void initFrame() {
        //init listeners
        final KeyAdapter keyListener = new KeyEventListener();
        final MouseEventListener mouseListener = new MouseEventListener(this);
        //Set frame location
        List<Resolution> devicesRes = ScreenUtil.getResolutions();
        if (devicesRes == null || devicesRes.size() <=0) {
            System.err.println("KMFrame init error, the number of master' screen is 0. ");
        }
        Resolution res = devicesRes.get(0);
        int screenWidth = res.getWidth();
        int screenHeight = res.getHeight();
        this.setSize(1200, 800);//设置Frame的大小
        this.setLocation((screenWidth - 1200) / 2, (screenHeight - 800) / 2);//设置Frame显示在屏幕中央

        this.setBackground(new Color(0, true));
        this.getContentPane().add(getMonitorPanel());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("KMBridge");
        this.setVisible(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.addKeyListener(keyListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.addMouseWheelListener(mouseListener);
    }

    public JComponent getMonitorPanel() {
        Resolution r1 = new Resolution();
        Resolution r2 = new Resolution();
        Resolution r3 = new Resolution();
        r1.setWidth(180);
        r1.setHeight(100);
        r2.setWidth(200);
        r2.setHeight(80);
        r3.setWidth(400);
        r3.setHeight(200);
        List<Resolution> resl = new ArrayList<Resolution>();
        resl.add(r1);
        resl.add(r2);
        resl.add(r3);
        JPanel p = new MonitorPanel(resl);
        p.setBackground(new Color(.5f, .5f, .5f, .6f));
        return p;
    }
}
