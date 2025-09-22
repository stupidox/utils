package com.hm.utils;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Rename02 {
    @Test
    public void demo1() throws Exception {
        String path = "D:\\private\\pictures\\comic\\韩漫\\母@L@Sな加々見先生とMなさん";
        File file = new File(path);
        File[] files = file.listFiles();
        List<File> list = Arrays.asList(files);
        list.sort(Comparator.comparing(File::lastModified));
        for (int i = 0; i < list.size(); i++) {
            File f = list.get(i);
            f.renameTo(new File(f.getParent(), f.getName().replaceAll("\\[.*\\]", "")));
        }
    }

    @Test
    public void demo2() throws Exception {
        String path = "D:\\private\\movies\\权娜拉紧身皮裤饭拍视频合集52部[lyzlk.cn]";
        File file = new File(path);
        File[] files = file.listFiles();
        List<File> list = Arrays.asList(files);
        String str = "【Hello Venus】";
        for (int i = 0; i < list.size(); i++) {
            File f = list.get(i);
            if (!f.getName().startsWith(str) && !f.getName().endsWith(".torrent")) {
                f.renameTo(new File(f.getParent(), str + f.getName()));
            }
        }
    }
}
