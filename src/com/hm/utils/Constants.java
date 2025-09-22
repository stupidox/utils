package com.hm.utils;


import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Constants {
    public static boolean isShiftUp = false;

    public static AtomicBoolean f = new AtomicBoolean(true);

    public static void showDialog(String str) {
        // 创建弹窗窗口
        JFrame frame = new JFrame("Window");
        int width = 130;
        int height = 100;

        // 设置弹窗位置为右下角
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int x = screenWidth - width;
        int y = screenHeight - height - 50;
        frame.setLocation(x, y);

        // 设置弹窗内容
        JLabel label = new JLabel(str);
        frame.getContentPane().add(label);

        // 设置弹窗样式
        frame.getContentPane().setBackground(Color.WHITE);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        // 显示弹窗
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.dispose();
    }
}
