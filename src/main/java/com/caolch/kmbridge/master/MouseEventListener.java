package com.caolch.kmbridge.master;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseEventListener extends MouseAdapter {
    JFrame jFrame;

    public MouseEventListener(JFrame frame) {
        super();
        this.jFrame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        System.out.println("Mouse wheel moved");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point screen_p = e.getLocationOnScreen();
        Point frame_p = this.jFrame.getLocation();

        //System.out.println((screen_p.x - frame_p.x) + ", " + (screen_p.y - frame_p.y));
    }
}
