package com.hm.utils;

import java.io.*;
import java.time.Duration;

public class AdjustSubs {
    public static void main(String[] args) throws Exception {
        String filePath = "D:\\private\\movies\\av\\NSFS-159 上司和部下的妻子 21～和垃圾上司的屈辱作人性交 希望美\\";
        String fileName = "NSFS-159-C.srt";
        File file = new File(filePath + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        int index = fileName.lastIndexOf("-C.");
        File newFile = new File(filePath + fileName.substring(0, index) + fileName.substring(index+2));
        FileWriter fw = new FileWriter(newFile);
        BufferedWriter bw = new BufferedWriter(fw);
        while((s =  br.readLine()) != null) {
            processLine(s, 167500, bw);
        }
        br.close();
        fw.close();
    }

    static void processLine(String line, int milliSecs, BufferedWriter fw) throws Exception {
        if(line.contains("-->")) { // 这一行是时间轴

            // 将字幕显示的起始时间和结束时间分开。
            String[] timespan = line.split("-->");

            // 起始时间的小时、分、秒、毫秒分开。
            String[] begin = timespan[0].split("[:,]");

            // 重点：把起始时间的小时、分、秒、毫秒统统加在一起构造一个Duration。
            // plus方法是可串行的，就像StringBuffer的append。
            Duration beginTime =
                    Duration.ofHours(Long.parseLong(begin[0].trim())).plus(
                            Duration.ofMinutes(Long.parseLong(begin[1].trim()))).plus(
                            Duration.ofSeconds(Long.parseLong(begin[2].trim()))).plus(
                            Duration.ofMillis(Long.parseLong(begin[3].trim())));

            // 结束时间也如法炮制。
            String[] end = timespan[1].split("[:,]");

            Duration endTime =
                    Duration.ofHours(Long.parseLong(end[0].trim())).plus(
                            Duration.ofMinutes(Long.parseLong(end[1].trim()))).plus(
                            Duration.ofSeconds(Long.parseLong(end[2].trim()))).plus(
                            Duration.ofMillis(Long.parseLong(end[3].trim())));

            // 把这两个时间分别加上我们希望的偏移量，也就是向前（milliSecs为负）或者向后移动的毫秒数，
            // 得到两个新的Duration
            Duration newStart = beginTime.plusMillis(milliSecs);
            Duration newEnd = endTime.plusMillis(milliSecs);

            // pw是一个PrintWriter，把调整后的一行时间轴写入新的字幕文件。
            fw.write(parse(newStart) + " --> " + parse(newEnd));
        } else {
            fw.write(line); // 不是时间轴行，原样打印
        }
        fw.newLine();
        fw.flush();
    }

    static String parse(Duration d) {
        long h = d.toHours(); // 得到小时数
        String sh = h<10 ? "0" + h : "" + h; // 如果只有一位数，加上个0

        // 为了得到后面的分，秒，毫秒，我们要将小时减掉，否则取分钟的时候会连小时算进去
        d = d.minusHours(h);

        long min = d.toMinutes(); // 得到分钟
        String smin = min<10 ? "0" + min : "" + min;
        d = d.minusMinutes(min); // 减掉分钟
        long s = d.getSeconds(); // 得到秒，注意这里是getSeconds，没有toSeconds方法
        String ss = s<10 ? "0" + s : "" + s;
        d = d.minusSeconds(s); // 减掉秒
        long m = d.toMillis(); // 得到毫秒
        String sm = m<10 ? "00" + m : (m<100 ? "0" + m : "" + m);
        return sh + ":" + smin + ":" + ss + "," + sm;
    }
}
