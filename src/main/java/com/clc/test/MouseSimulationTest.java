package com.clc.test;

import java.awt.*;

public class MouseSimulationTest {

public static  void main(String[] args) throws AWTException, InterruptedException {
    Robot robot = new Robot();
    robot.mouseMove(10,-10);
//    Thread.sleep(1000);
    robot.mouseWheel(-14);
    robot.delay(1000);
    robot.mouseMove(-20,-30);
//    Thread.sleep(1000);
    robot.mouseWheel(5);

}
}











