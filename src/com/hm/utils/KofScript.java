package com.hm.utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class KofScript {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        SimpleDateFormat formatter= new SimpleDateFormat("MM-dd HH:mm:ss");
        Thread.sleep(3000);
        // 开始
        while (true) {
            System.out.print(formatter.format(new Date()) + " - ");
            robot.keyPress(KeyEvent.VK_F1);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_F1);
            Thread.sleep(500);
            robot.keyPress(KeyEvent.VK_F1);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_F1);
            Thread.sleep(500);
            // 调整难度
            robot.keyPress(KeyEvent.VK_W);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_W);
            Thread.sleep(300);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(300);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(300);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(300);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_W);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_W);
            Thread.sleep(300);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(300);
            // 选择模式
            robot.keyPress(KeyEvent.VK_S);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_S);
            Thread.sleep(300);
            robot.keyPress(KeyEvent.VK_S);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_S);
            Thread.sleep(300);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(1000);
            // 进入选人界面
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(3500);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(1500);
            // 开始选人
            robot.keyPress(KeyEvent.VK_D);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_D);
            Thread.sleep(300);
            robot.keyPress(KeyEvent.VK_D);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_D);
            Thread.sleep(300);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(500);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            Thread.sleep(500);
            robot.keyPress(KeyEvent.VK_J);
            Thread.sleep(100);
            robot.keyRelease(KeyEvent.VK_J);
            System.out.println(formatter.format(new Date()));
            Thread.sleep(90000);
        }
    }
}
