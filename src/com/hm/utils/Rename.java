package com.hm.utils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Rename {
    public static void main(String[] args) throws Exception {
        renameFiles("D:\\private\\pictures\\best\\古力娜扎\\000\\096");
    }

    public static void renameFiles(String path) throws Exception {
        System.out.println("\33[31m" + path + "\33[0m");
        File file = new File(path);
        File[] files = file.listFiles();
        if (Objects.isNull(files) || files.length == 0) {
            return;
        }
        List<File> list = Arrays.asList(files);
        list.sort(Comparator.comparing(File::getName));
        for (int i = 0; i < list.size(); i++) {
            File f = list.get(i);
            String name = f.getName();
            if (f.isFile()) {
                int j = name.lastIndexOf(".");
                if (!name.substring(0, j).equals(String.format("%03d", i+1))) {
                    System.out.println(name.substring(0, j) + " - " + String.format("%03d", i + 1));
                    f.renameTo(new File(f.getParent(), String.format("%03d", i + 1) + name.substring(j)));
                }
            } else {
                System.out.println(name + " - " + String.format("%03d", i+1));
                f.renameTo(new File(f.getParent(), String.format("%03d", i+1)));
            }
        }
    }
}
