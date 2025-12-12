package com.hm.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WindowsUtils {

    /**
     * 本地文件当做数据库
     * @param path 数据库文件
     */
    public static List<String> readFromFile(String path) throws Exception {
        List<String> pathList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String s = null;
        while(Objects.nonNull((s = br.readLine()))) {
            pathList.add(s);
        }
        br.close();
        return pathList;
    }
}
