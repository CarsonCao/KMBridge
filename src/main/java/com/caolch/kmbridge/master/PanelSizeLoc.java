package com.caolch.kmbridge.master;

import com.caolch.kmbridge.common.Resolution;
import java.awt.*;

public class PanelSizeLoc {
    public Resolution resolution;
    public Point point;
    public PanelSizeLoc(Resolution res, Point p) {
        resolution = res;
        point = p;
    }
    public PanelSizeLoc(int x, int y, int width, int height){
        resolution = new Resolution();
        resolution.setHeight(height);
        resolution.setWidth(width);
        point = new Point(x,y);
    }
    public int getX(){ return point.x; }
    public int getY(){return point.y;}
    public int getWidth(){return resolution.getWidth();}
    public int getHeight(){return resolution.getHeight();}
}
