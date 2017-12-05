package com.crazy.test;


import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    private static List<String> filelist = new ArrayList<String>();

    @Test
    public void Test() throws IOException {

        String filePath = "F:\\IdeaProject\\eps\\eps-admin\\src";

        getFiles(filePath);

        for (String file : filelist) {
            if (BufferedReaderAndBufferedWriter(file, "F:\\javadoc.txt")) {
                System.out.println("文件写出成功");
            } else {
                System.out.println("文件写出失败");
                break;
            }
        }

        System.out.println(filelist.size());
    }

    /**
     * 用递归获取指定路径下所有目录和子目录下的java文件的绝对路径
     */
    public static void getFiles(String filePath) {
        File root = new File(filePath);
        File[] files = root.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                getFiles(file.getAbsolutePath());
            } else {
                if (file.getAbsolutePath().endsWith(".java")) {
                    filelist.add(file.getAbsolutePath());//将文件绝对路径放入到集合里面
                }
            }
        }
    }

    /**
     * 将指定文件的内容复制到另一个新的文件中
     */
    public static Boolean BufferedReaderAndBufferedWriter(String inputFilePath, String outputFilePath) {
        BufferedReader br = null;
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
            br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), "UTF-8"));
            String tempString = null;
            while ((tempString = br.readLine()) != null) {
                bw.write(tempString);//输出字符串
                bw.newLine();//换行
                bw.flush();
            }
            br.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
