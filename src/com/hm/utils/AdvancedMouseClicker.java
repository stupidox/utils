package com.hm.utils;

import java.awt.*;
import java.awt.event.InputEvent;

public class AdvancedMouseClicker implements Runnable {
    public static void main(String[] args) throws Exception {
        new Thread(new KeyboardHook()).start();
//        new Thread(new MouseHook()).start();
    }

    public void run() {
        Constants.showDialog("start!");
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (Constants.f.get()) {
            assert robot != null;
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            // 间隔时间
            try {
                Thread.sleep(530);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Constants.showDialog("end!");
    }
}
