package com.hm.utils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Rename {
    public static void main(String[] args) throws Exception {
        String path = "D:\\private\\pictures\\best\\迪丽热巴\\000\\017";
        File file = new File(path);
        File[] files = file.listFiles();
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
