package com.hm.utils;

import java.io.File;
import java.util.regex.Pattern;

public class Rename {
    public static void main(String[] args) {
        String path = "D:\\game\\RA2 Tools\\TNKD";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isFile()) {
                continue;
            }
            String name = f.getName();
            name = name.replace("SUPTNKD", "TURRETTNKD");
            f.renameTo(new File(f.getParent(), name));
        }
    }
}
