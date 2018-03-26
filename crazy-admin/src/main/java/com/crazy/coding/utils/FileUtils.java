package com.crazy.coding.utils;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class FileUtils {

    public static Boolean BufferedWriter(List list, String outputFilePath) {
        BufferedWriter bw = null;
        File file = null;//输出路径
        try {
            file = new File(outputFilePath);
            if (!file.exists()) {
                try {
                    file.createNewFile();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //输出路径检查
            //FileWriter里面两个参数，第二个 参数设置为true为不覆盖;
            // 如果覆盖的话没有第二个参数，或者将第二个参数设置为false）；
            bw = new BufferedWriter(new FileWriter(file, true));
            //读取文件
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                Object obj = it.next();
                bw.write(obj.toString());//输出字符串
                bw.newLine();//换行
                bw.flush();
            }

            bw.close();

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
