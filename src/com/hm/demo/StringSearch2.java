package com.hm.demo;

import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class StringSearch2 {
    public static void main(String[] args) throws Exception {
        File file = new File("F:\\Movies\\喜剧\\意大利电影");
        String s = "不是这个星球的 1988：https://pan.quark.cn/s/762e2b6cc062\n" +
                "星爷看的那一部（不让分享，自己离线下吧）：https://pan.quark.cn/s/17076191f78f\n" +
                "最高激情 1969：https://pan.quark.cn/s/0b7bffa999e0\n" +
                "薄伽丘的其他短篇 1972：https://pan.quark.cn/s/e6fb5ee8300e\n" +
                "薄伽丘1 1972：https://pan.quark.cn/s/87ce6a430eeb\n" +
                "悬崖下的野餐 1975 完美中字：https://pan.quark.cn/s/2ea06c0b66ab\n" +
                "切断 1984：https://pan.quark.cn/s/71f3e70d7913\n" +
                "露西亚的情人 2001：https://pan.quark.cn/s/8ce14cf904b9\n" +
                "欲海轮回 1997：https://pan.quark.cn/s/7d874d681e73\n" +
                "激情惊爆点 1994：https://pan.quark.cn/s/e427decd1319\n" +
                "金童玉女 韩字完整版 1982：https://pan.quark.cn/s/49872f4ea26a\n" +
                "朦胧的欲望 1977：https://pan.quark.cn/s/02e294caf408\n" +
                "太空英雌芭丽娜 1968：https://pan.quark.cn/s/35aee6ae6aff\n" +
                "德古拉的女儿 1972：https://pan.quark.cn/s/63fe8cebebc7\n" +
                "黑色安息日 1963：https://pan.quark.cn/s/15aa3e1edf08\n" +
                "吸血妖姬 中字 1973：https://pan.quark.cn/s/091f7d1f1271\n" +
                "痴迷女杀手 1971：https://pan.quark.cn/s/7489f9869abd\n" +
                "墓地亡灵首部曲：猛鬼倾巢 1971：https://pan.quark.cn/s/013a639d036b\n" +
                "叛逆者 1982：https://pan.quark.cn/s/9790d163a907\n" +
                "夜童 1972：https://pan.quark.cn/s/94e2d599f9f0\n" +
                "随性而来 1978：https://pan.quark.cn/s/9a3653964f3f\n" +
                "血溅新娘 1972：https://pan.quark.cn/s/9565931f9563\n" +
                "克里斯.米勒的堕落 1973：https://pan.quark.cn/s/9dffee45215b\n" +
                "黎明的强J者 1978：https://pan.quark.cn/s/63627c9ff657\n" +
                "暧妹 2017：https://pan.quark.cn/s/fae0e6c4cb58\n" +
                "坟墓里升起的恐惧 1973：https://pan.quark.cn/s/c7b0cfad2fd7\n" +
                "熱帯性気候写真：https://pan.quark.cn/s/9e7bb7d24607\n" +
                "不知不觉诱惑你 1998：https://pan.quark.cn/s/cd71b9ad7357\n" +
                "红辣椒 1991：https://pan.quark.cn/s/245643e3e97a\n" +
                "不良行为 1979：https://pan.quark.cn/s/982c87edf70b\n" +
                "布达佩斯小酒馆：https://pan.quark.cn/s/e282dafd828c\n" +
                "黑天使：https://pan.quark.cn/s/ed4cfd1e043c\n" +
                "困惑的浪漫：https://pan.quark.cn/s/ca990e6f09d7\n" +
                "奸情：https://pan.quark.cn/s/2160c2809ab9\n" +
                "激情信箱：https://pan.quark.cn/s/a6724bdaad57\n" +
                "米兰达：https://pan.quark.cn/s/333886a162e8\n" +
                "凯蒂夫人 1976：https://pan.quark.cn/s/6dc1d9d15133\n" +
                "偷窥狂人：https://pan.quark.cn/s/8acc6f2a5e71\n" +
                "嚎叫 1970：https://pan.quark.cn/s/e06ba70c827b\n" +
                "滴血碧玉肌 中字 1972：https://pan.quark.cn/s/bccdfc2e39d9\n" +
                "桃色情人 中字 1992：https://pan.quark.cn/s/117a72e5633d\n" +
                "嗜血杀手 中字 1975：https://pan.quark.cn/s/578e860243e8\n" +
                "吸血惊情 1995：https://pan.quark.cn/s/bf6aed63a91d\n" +
                "波丽露 1984：https://pan.quark.cn/s/b681da2b51c2\n" +
                "疯狂靓妹仔 1983：https://pan.quark.cn/s/3bd973e4ec86\n" +
                "治疗的容颜 1969：https://pan.quark.cn/s/5710dbaf2b3a\n" +
                "偷天惊情 1972： https://pan.quark.cn/s/a4600841922a\n" +
                "执法女先锋2 1994：https://pan.quark.cn/s/c4761a8772ad\n" +
                "三春艳史 1971：https://pan.quark.cn/s/9ac0d159ac0b\n" +
                "飞来艳福 1983：https://pan.quark.cn/s/414d34ef2582\n" +
                "孽欲畸恋 1995：https://pan.quark.cn/s/d25a1b8cb371\n" +
                "我姐姐是法官 1976：https://pan.quark.cn/s/eab0daad5801\n" +
                "销魂梦 1976：https://pan.quark.cn/s/6f1c966432e6\n" +
                "等待夫人 1994：https://pan.quark.cn/s/c8609444b0c7\n" +
                "偷月情1 1988：https://pan.quark.cn/s/778ca4b3bdb5\n" +
                "偷月情2 1995：https://pan.quark.cn/s/5665f67a8162\n" +
                "坏女人 1984：https://pan.quark.cn/s/adc50a0f012b\n" +
                "克洛伊 1996：https://pan.quark.cn/s/77c04e97e17f\n" +
                "大电站 2013：https://pan.quark.cn/s/4c6d024f75ed\n" +
                "执法女先锋 1993：https://pan.quark.cn/s/87269964e71f\n" +
                "肉体的恶魔 1996：https://pan.quark.cn/s/c8b5bc582078\n" +
                "猎杀边缘 1974：https://pan.quark.cn/s/04545aa9be00\n" +
                "糖果 1968：https://pan.quark.cn/s/ba77391ef267\n" +
                "成为大人之前 1978：https://pan.quark.cn/s/71ea529d1b4e\n" +
                "神采飞扬 1993：https://pan.quark.cn/s/5ea0a7e8a08f\n" +
                "激情沸点 1990：https://pan.quark.cn/s/74cf4f2f17ec\n" +
                "邪恶夜晚 1985：https://pan.quark.cn/s/31101b38998e\n" +
                "星光迷乱 1989：https://pan.quark.cn/s/6e21fe1021dd\n" +
                "芳香 1987：https://pan.quark.cn/s/785531c090bf\n" +
                "学校 1975：https://pan.quark.cn/s/61999fa82368\n" +
                "对吸血鬼的欲望 1971：https://pan.quark.cn/s/06d2bc2e6934\n" +
                "女人的倾倒 1974：https://pan.quark.cn/s/f8fae4e6a4e2\n" +
                "法国X谋杀 1972：https://pan.quark.cn/s/8e96f7a0359d\n" +
                "碎块 1982：https://pan.quark.cn/s/257afac14f6b\n" +
                "堕落 1986：https://pan.quark.cn/s/703671c8518d\n" +
                "刀在喉咙 1986：https://pan.quark.cn/s/83d582a02c7a\n" +
                "温暖的夜晚 1969：https://pan.quark.cn/s/9787316b1432\n" +
                "逃避梦魇 1985：https://pan.quark.cn/s/37ae8f5cdd5b\n" +
                "女煞星续集 1969：https://pan.quark.cn/s/e991c13c0247\n" +
                "处女巫 1972：https://pan.quark.cn/s/81595481c459\n" +
                "地狱杀手 1976：https://pan.quark.cn/s/f5aed24377e6\n" +
                "吸血惊情 1995：https://pan.quark.cn/s/d138b74916b0\n" +
                "吸血鬼盛宴 1973：https://pan.quark.cn/s/dd8182b85df2\n" +
                "撒旦啦啦队 1977：https://pan.quark.cn/s/6515d32aedc0\n" +
                "女摄影师的欲望 1987：https://pan.quark.cn/s/040f02b1afed\n" +
                "瑞典少女 1971：https://pan.quark.cn/s/e866d5418159\n" +
                "旅客 1979：https://pan.quark.cn/s/4225b74eae7d\n" +
                "贾丝廷 1969：https://pan.quark.cn/s/20b287f9ea39\n" +
                "复仇 1968：https://pan.quark.cn/s/4b95de740bf2";
        String[] files = file.list();
        List<String> list = new ArrayList<>();
        for (String fname : files) {
            int i = fname.indexOf(" ");
            if (i == -1) {
                i = fname.indexOf(".");
            }
            list.add(fname.substring(0, i));
        }
        List<String> seList = new ArrayList<>();
        String[] ses = s.split("\n");
        for (String se : ses) {
            String[] ss = se.split(" ");
            seList.add(ss[0]);
        }
        Map<Boolean, List<String>> collect = seList.stream().collect(Collectors.partitioningBy(obj -> list.stream().anyMatch(obj2 -> obj2.equals(obj))));
        Set<Boolean> bs = collect.keySet();
        bs.forEach((e) -> {
            if (e.equals(false)) {
                System.out.println(collect.get(e));
            }
        });
        System.out.println();
    }
}
