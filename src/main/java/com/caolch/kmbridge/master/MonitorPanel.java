package com.caolch.kmbridge.master;

import com.caolch.kmbridge.Utils.Resolution;
import com.caolch.kmbridge.common.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 模拟slave显示器
 */
public class MonitorPanel extends JPanel {

    public List<Resolution> devices;

    public MonitorPanel(List<Resolution> res) {
        super();
        devices = res;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int preX = 10;
        for (Resolution r : devices) {
            drawMonitor(g, preX , 10, r.getWidth(), r.getHeight());
            preX += r.getWidth() + (int)Constants.STROKE_BORDER;
        }
    }

    public void drawMonitor(Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(Constants.STROKE_BORDER));
        g2d.drawRoundRect( x, y, width, height, 20, 20);
        g2d.dispose();
    }
}