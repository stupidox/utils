package com.hm.demo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Hanman {
    public static void main(String[] args) throws Exception {
        search("D:\\private\\pictures\\comic02\\韩漫\\美丽新世界1");
    }

    public static void search(String path) throws Exception {
        File dir = new File(path);
        File[] files = dir.listFiles();
        List<File> dirs = Arrays.asList(files);
        dirs.sort(Comparator.comparing(File::lastModified));
        int i = 1;
        for (File file : dirs) {
            List<File> pics = new ArrayList<>();
            loop(file, pics);
            pics.sort(Comparator.comparing(File::lastModified));
            int j = 1;
            for (File pic : pics) {
                File par = new File("D:\\private\\pictures\\comic02\\韩漫\\美丽新世界\\"
                        + String.format("%03d", i));
                if (!par.exists()) {
                    par.mkdirs();
                }
                Files.copy(Paths.get(pic.getAbsolutePath()),
                        Paths.get("D:\\private\\pictures\\comic02\\韩漫\\美丽新世界\\"
                                + String.format("%03d", i) + "\\" + String.format("%03d", j) + ".jpg"));
                ++j;
            }
            ++i;
        }
    }

    public static void loop(File dir, List<File> files) {
        File[] allFiles = dir.listFiles();
        for (File allFile : allFiles) {
            if (allFile.isFile()) {
                files.add(allFile);
            } else {
                loop(allFile, files);
            }
        }
    }
}
