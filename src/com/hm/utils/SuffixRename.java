package com.hm.utils;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SuffixRename {
    public static void main(String[] args) throws Exception {
        String path = "F:\\aiPics\\为萝莉而战";
        File file = new File(path);
        File[] files = file.listFiles();
        List<File> list = Arrays.asList(files);
        // Files.getLastModifiedTime(file.toPath()).toMillis();
        // list.sort(Comparator.comparing(File::lastModified));
        for (int i = 0; i < list.size(); i++) {
            File f = list.get(i);
            String name = f.getName();
            if (f.isFile() && name.endsWith("(1).zip")) {
                f.renameTo(new File(f.getParent(), name.substring(0, name.lastIndexOf("(")) + ".zip"));
            }
        }
    }

    public static void renameFile(File file) {

    }
}
