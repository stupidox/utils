package com.hm.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ChangeDir {
    public static void main(String[] args) {
        File file = new File("D:\\private\\movies\\脸红Dearie微密圈共157套。火辣性感的微密圈照片和视频写真。稀有热门资源");
        use(file);
    }

    public static void use(File file) {
        File[] files = file.listFiles();
        if (file.isDirectory()) {
            if (Objects.nonNull(files)) {
                change(file, 0);
            }
        }
    }

    public static void change(File file, int level) {
        if (++level > 3) {
            return;
        }
        File[] files = file.listFiles();
        if (file.isDirectory()) {
            if (Objects.nonNull(files)) {
                for (int i = 0; i < level; i++) {
                    System.out.print("-");
                }
                System.out.println(file.getName());
                for (File dir : files) {
                    change(dir, level);
                }
                if (level == 3) {
                    System.out.println(files[0].getAbsolutePath());
                    System.out.println(files[0].getParentFile().getParentFile().getAbsolutePath());
                    try {
                        FileUtils.copyDirectory(files[0], files[0].getParentFile().getParentFile());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (level == 3) {
                    try {
                        System.out.println(file.getAbsolutePath());
                        FileUtils.deleteDirectory(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
