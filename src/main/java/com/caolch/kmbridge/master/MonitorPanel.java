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

    private List<Resolution> devices;

    public MonitorPanel(List<Resolution> res) {
        super();
        devices = res;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int preX = (int) Constants.STROKE_BORDER;
        for (int i = 0; i < devices.size(); i++) {
            Resolution r = devices.get(i);
            drawMonitor(g, preX, (int) Constants.STROKE_BORDER, r.getWidth(), r.getHeight(), i);
            preX += r.getWidth() + (int) Constants.STROKE_BORDER;
        }
    }

    public void drawMonitor(Graphics g, int x, int y, int width, int height, int tag) {
        Graphics2D g2d = (Graphics2D) g.create();
        Font font = new Font("TimesRoman", Font.BOLD, 50);

        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(Constants.STROKE_BORDER));
        g2d.drawRoundRect(x, y, width, height, 20, 20);
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Monitor-" + (tag + 1), x + width / 2 - 100, y + height / 2);
        g2d.dispose();
    }
}