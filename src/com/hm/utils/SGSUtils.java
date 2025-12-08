package com.hm.utils;

import org.junit.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SGSUtils implements Runnable {

    // 开始秒杀
    @Test
    public void run() {
        int count = 3;
        try {
            Robot robot = new Robot();

            // 防止其他活动干扰
            robot.mouseMove((int) (1248/1.5), (int) (820/1.5));
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(-1, -1);

            for (int i = 0; i < count; i++) {
                flashSale();
            }

            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_ALT);
            Thread.sleep(41);

            // 防止其他活动干扰
            robot.mouseMove((int) (1249/1.5), (int) (820/1.5));
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(-1, -1);

            for (int i = 0; i < count; i++) {
               flashSale();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 秒杀
    public void flashSale() {
        // chooseItem(1);
        // chooseItem(2);
        chooseItem(3);
    }

    public void chooseItem(int i) {
        try {
            Robot robot = new Robot();
            robot.mouseMove(-1, -1);

            if (i == 1) {
                // 第一个物品
                // robot.mouseMove((int) (791/1.5), (int) (1011/1.5));
                robot.mouseMove((int) (758/1.5), (int) (1031/1.5));
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(-1, -1);
            } else if (i == 2) {
                // 第二个物品
                // robot.mouseMove((int) (1265/1.5), (int) (1013/1.5));
                robot.mouseMove((int) (1075/1.5), (int) (1027/1.5));
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(-1, -1);
            } else if (i == 3) {
                // 第三个物品
                // robot.mouseMove((int) (1730/1.5), (int) (1011/1.5));
                robot.mouseMove((int) (1397/1.5), (int) (1024/1.5));
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseMove(-1, -1);
            }
            // 取消
            // robot.mouseMove((int) (1248/1.5), (int) (820/1.5));

            // 确认
            robot.mouseMove((int) (1049/1.5), (int) (821/1.5));

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(-1, -1);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // 获取鼠标位置
    public static void getMousePosition() {
        // 创建鼠标操作对象
        // MouseInfo提供了获取鼠标信息的方法，例如鼠标指针的位置和鼠标按钮的数量
        PointerInfo info = MouseInfo.getPointerInfo();
        // 调用GetLocation方法，获取鼠标位置
        Point location = info.getLocation();
        System.out.println(location.x + ", " + location.y);

    }

    public static void main(String[] args) throws Exception {
        Thread.sleep(1500);
        getMousePosition();
    }
}
