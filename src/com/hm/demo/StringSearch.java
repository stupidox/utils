package com.hm.demo;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringSearch {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\1.txt");
        String s = "莫逆平之加入了队伍聊天\n" +
                "灬Anhui丨DaSheng加入了队伍聊天\n" +
                "丿开丨心丶 (石甲虫)加入了队伍聊天\n" +
                "Theshy之拉胯版加入了队伍聊天\n" +
                "迷人滴微笑加入了队伍聊天";
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(file);
        char[] chs = new char[1024 * 10];
        int l;
        while((l = fr.read(chs)) != -1) {
            sb.append(chs, 0, l);
        }
        fr.close();

        String con = sb.toString();
        String[] cons = con.split("\t.*");
        List<String> list = new ArrayList<>();
        List<String> seList = new ArrayList<>();
        for (String con1 : cons) {
            if (con1 != null && !con1.trim().equals("")) {
                list.add(con1.trim());
            }
        }
        String[] ses = s.split("加入了队伍聊天");
        for (String se : ses) {
            if (se != null && !se.trim().equals("")) {
                seList.add(se.trim());
            }
        }
        Map<Boolean, List<String>> collect = list.stream().collect(Collectors.partitioningBy(obj -> seList.stream().anyMatch(obj2 -> obj2.equals(obj))));
        Set<Boolean> bs = collect.keySet();
        bs.forEach((e) -> {
            if (e.equals(true)) {
                System.out.println(collect.get(e));
            }
        });
        System.out.println();
    }
}
