package com.hm.utils;

import java.io.File;
import java.util.regex.Pattern;

public class Rename {
    public static void main(String[] args) {
        String path = "F:\\aiPics\\为萝莉而战";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isFile()) {
                continue;
            }
            String name = f.getName();
            String fileName = name.substring(0, name.lastIndexOf("."));
            String suffix = name.substring(name.lastIndexOf("."));
            if (!suffix.endsWith(".zip") && !suffix.endsWith(".rar")) {
                if (Pattern.matches(".*z.*i.*p", suffix)) {
                    f.renameTo(new File(f.getParent(), fileName + ".zip"));
                } else if (Pattern.matches(".*r.*a.*r", suffix)) {
                    f.renameTo(new File(f.getParent(), fileName + ".rar"));
                }
            }
        }
    }
}
