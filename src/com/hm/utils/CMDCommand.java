package com.hm.utils;

import java.io.*;
import java.util.Objects;

public class CMDCommand {
    public static void main(String[] args) throws Exception {
        File dir = new File("E:\\private\\videos");
        File[] files = dir.listFiles();
        for (File f : files) {
            loop(f, f.getName());
        }

    }

    public static void loop(File file, String name) throws Exception {
        File[] files = file.listFiles();
        if (Objects.nonNull(files)) {
            for (File f : files) {
                if (f.isDirectory()) {
                    loop(f, name);
                } else {
                    if (f.getName().endsWith(".m4s")) {
                        executive("ffmpeg -i " + f.getParentFile().getAbsolutePath() + "" +
                                "\\video.m4s -i " + f.getParentFile().getAbsolutePath() + "\\audio.m4s -vcodec copy -acodec copy E:\\private\\videos\\cmd\\"
                                + name + ".mp4");
                        break;
                    }
                }
            }
        }
    }

    //一般的执行方法，有时执行exe会卡在那    stmt要执行的命令
    public static void executive(String stmt) {
        Runtime runtime = Runtime.getRuntime();  //获取Runtime实例
        //执行命令
        try {
            String[] command = {"cmd", "/c", stmt};
            Process process = runtime.exec(command);
            // 标准输入流（必须写在 waitFor 之前）
            String inStr = consumeInputStream(process.getInputStream());
            // 标准错误流（必须写在 waitFor 之前）
            String errStr = consumeInputStream(process.getErrorStream()); //若有错误信息则输出
            int proc = process.waitFor();
            if (proc == 0) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败" + errStr);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费inputStream，并返回
     */
    public static String consumeInputStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));
        StringBuilder sb = new StringBuilder();
        Thread thread = new Thread(() -> {
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        return sb.toString();
    }
}
