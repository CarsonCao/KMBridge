package com.caolch.kmbridge.master;

import com.caolch.kmbridge.common.Resolution;
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
        if (devicesRes == null || devicesRes.size() <= 0) {
            System.err.println("KMFrame init error, the number of master' screen is 0. ");
        }
        Resolution frameSize = devicesRes.get(0);
        Resolution workingSize = new Resolution();
        workingSize.setHeight(frameSize.getHeight() - 30 - 8);
        workingSize.setWidth(frameSize.getWidth() - 8 - 8);
        int screenWidth = frameSize.getWidth();
        int screenHeight = frameSize.getHeight();

        this.setSize(screenWidth, screenHeight);//设置Frame的大小
        this.setLocation(0, 0);//设置Frame显示在屏幕中央

        this.setBackground(new Color(0, true));
        this.getContentPane().add(getMonitorPanel(workingSize));
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

    public JComponent getMonitorPanel(Resolution masterRes) {
        //for test===================
        Resolution r1 = new Resolution();
        Resolution r2 = new Resolution();
        r1.setWidth(1920);
        r1.setHeight(1080);
        r2.setWidth(1920);
        r2.setHeight(1080);
        List<Resolution> resList = new ArrayList<Resolution>();
        resList.add(r1);
       // resl.add(r2);
        //===========================
        List<PanelSizeLoc> pslList = new ArrayList<PanelSizeLoc>();
        if (resList.size() == 1) {
            Point point = new Point(0, 0);
            Resolution res = resList.get(0);
            double masterRatio = (double) masterRes.getHeight() / (double) masterRes.getWidth();
            double resRatio = (double) res.getHeight() / (double) res.getWidth();
            if (masterRatio - resRatio >= 0.000001) {
                res.setWidth(masterRes.getWidth());
                res.setHeight((int) (masterRes.getWidth() * resRatio));
                point.setLocation(0, (masterRes.getHeight() - res.getHeight()) / 2);
                PanelSizeLoc psl = new PanelSizeLoc(res, point);
                pslList.add(psl);
            } else {
                res.setHeight(masterRes.getHeight());
                res.setWidth((int) (masterRes.getHeight() / resRatio));
                point.setLocation((masterRes.getWidth() - res.getWidth()) / 2, 0);
                PanelSizeLoc psl = new PanelSizeLoc(res, point);
                pslList.add(psl);
            }

        }


        JPanel p = new MonitorPanel(pslList);
        p.setBackground(new Color(.5f, .5f, .5f, .6f));
        return p;
    }
}
