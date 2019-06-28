package com.clc.test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MouseSimulationTest {

public static  void main(String[] args) throws AWTException, InterruptedException {
    Robot robot = new Robot();

    for (int i = 0; i < 60; i++) {
        robot.mouseMove(1000 + i *10,800);
       // robot.delay(1);
    }

//    Thread.sleep(1000);
//    robot.mouseWheel(-14);
    robot.delay(1000);
 //   robot.mouseMove(-20,-30);
    robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);		// 模拟按下鼠标左键
    robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键
    robot.keyPress(KeyEvent.VK_Z);
    robot.keyRelease(KeyEvent.VK_Z);
    robot.keyPress(KeyEvent.VK_B);
    robot.keyRelease(KeyEvent.VK_B);




}
}











