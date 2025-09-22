package com.hm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        File f1 = new File("E:\\private\\videos\\123333\\c_29152445576\\80\\video.m4s");
        File f2 = new File("E:\\private\\videos\\114336458607190\\c_29413412585\\112\\video111.m4s");
        File f3 = new File("E:\\private\\videos\\114336458607190\\c_29413412585\\112\\video.m4s");

        FileInputStream fis1 = new FileInputStream(f1);
        FileInputStream fis2 = new FileInputStream(f2);
        FileOutputStream fos = new FileOutputStream(f3);
        int length = 800;
        byte[] bt1 = new byte[length];
        byte[] bt2 = new byte[length];
        fis1.read(bt1);
        fis2.read(bt2);
        fis1.close();
        fis2.close();
        System.out.println(Byte2Hex(bt1));
        int len = 0;
        boolean f = true;
        fis2 = new FileInputStream(f2);
        while ((len = fis2.read(bt2)) != -1) {
            if (f) {
                // for (int i = 0; i < bt2.length; i++) {
                //     if (bt2[i] == -65) {
                //         bt2[i] = 127;
                //         break;
                //     }
                // }
                // f = false;
                // System.out.println(Byte2Hex(bt2));
                for (int i = 0; i < bt1.length; i++) {
                    bt2[i] = bt1[i];
                }
                System.out.println(Byte2Hex(bt2));
                f = false;
            }
            fos.write(bt2, 0, len);
            fos.flush();
        }
        fis2.close();
        fos.close();
    }

    //16进制字符串转byte数组
    public static byte[] Hex2Byte(String inHex) {

        String[] hex=inHex.split(" ");//将接收的字符串按空格分割成数组
        byte[] byteArray=new byte[hex.length];

        for(int i=0;i<hex.length;i++) {
            //parseInt()方法用于将字符串参数作为有符号的n进制整数进行解析
            byteArray[i]=(byte)Integer.parseInt(hex[i],16);
        }

        return byteArray;

    }

    public static String Byte2Str(byte[] inByte) {

        StringBuilder sb=new StringBuilder();
        String str;

        for (byte b : inByte) {
            sb.append(b);//将16进制加入字符串
            sb.append(" ");
        }
        str=sb.toString();
        return str;
    }

    public static String Byte2Hex(byte[] inByte) {

        StringBuilder sb=new StringBuilder();
        String hexString;

        for(int i=0;i<inByte.length;i++) {

            //toHexString方法用于将16进制参数转换成无符号整数值的字符串
            String hex=Integer.toHexString(inByte[i]);

            if(hex.length()==1) {
                sb.append("0");//当16进制为个位数时，在前面补0
            }
            sb.append(hex);//将16进制加入字符串
            sb.append(" ");//16进制字符串后补空格区分开

        }

        hexString=sb.toString();
        hexString=hexString.toUpperCase();//将16进制字符串中的字母大写

        return hexString;
    }
}
