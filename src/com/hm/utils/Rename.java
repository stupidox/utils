package com.hm.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Rename {
    public static void main(String[] args) throws Exception {
        try {
            // 打包成jar后的控制台交互逻辑
            // Scanner scanner = new Scanner(System.in);

            List<String> pathList = WindowsUtils.readFromFile("D:\\private\\dirs.txt");
            for (String path : pathList) {
                renameFiles(path);
            }

            // 等待用户输入，防止窗口一闪而过
            // scanner.nextLine();
            // scanner.close();
        } catch (Exception e) {
            // 捕获所有异常，并输出到控制台（CMD中能看到，双击时如果窗口停留也能看到）
            e.printStackTrace();
            try {
                Thread.sleep(10000); // 异常时休眠10秒，方便查看报错
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void renameFiles(String path) throws Exception {
        System.out.println("\33[31m" + path + "\33[0m");
        // 打包jar的时候识别不了变色，用下面的
        // System.out.println(path);
        Path filePath = Paths.get(path);
        File file = filePath.toFile();
        File[] files = file.listFiles();
        List<File> list = Arrays.asList(files);
        list.sort(Comparator.comparing(File::getName));
        String name = null;
        for (int i = 0; i < list.size(); i++) {
            File f = list.get(i);
            String fileName = f.getName();
            if (f.isFile()) {
                // 文件按3位数从1开始改名
                name = String.format("%03d", i + 1);
                int j = fileName.lastIndexOf(".");
                if (!new File(path, name + fileName.substring(j)).exists() && !fileName.substring(0, j).equals(name)) {
                    System.out.println(fileName.substring(0, j) + " - " + name);
                    f.renameTo(new File(f.getParent(), name + fileName.substring(j)));
                }
            } else {
                System.out.println(fileName + " - " + name);
                f.renameTo(new File(f.getParent(), name));
            }
        }
    }
}
