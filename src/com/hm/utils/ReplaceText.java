package com.hm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class ReplaceText {
    public static void main(String[] args) {
        File dir = new File("F:\\temp\\novel\\txt");
        File[] files = dir.listFiles();

        try {
            FileChannel resultFileChannel = new FileOutputStream("F:\\temp\\novel\\《江山风月剑》.txt", true).getChannel();
            for (int i = 0; i < Objects.requireNonNull(files).length; i ++) {
                if (!files[i].getName().endsWith(".txt")) {
                    continue;
                }
                FileChannel blk = new FileInputStream(files[i]).getChannel();
                resultFileChannel.transferFrom(blk, resultFileChannel.size(), blk.size());
                blk.close();
            }
            resultFileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
