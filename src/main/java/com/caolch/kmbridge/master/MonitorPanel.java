package com.caolch.kmbridge.master;

import com.caolch.kmbridge.common.Resolution;
import com.caolch.kmbridge.common.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 模拟slave显示器
 */
public class MonitorPanel extends JPanel {

    private List<PanelSizeLoc> devices;

    public MonitorPanel(List<PanelSizeLoc> res) {
        super();
        devices = res;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int preSize = (int) Constants.STROKE_BORDER;
        for (int i = 0; i < devices.size(); i++) {
            PanelSizeLoc psl = devices.get(i);
            drawMonitor(g, psl.getX() + preSize, psl.getY() + preSize,
                    psl.getWidth() - preSize * 2, psl.getHeight() - preSize * 2, i);
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