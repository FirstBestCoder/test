package com.liuzm.test;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SavePicture {

    public static void main(String[] args) {
        String urlString = "http://fcimage.fangcang.com/images/hotels/846/120846/201706231498192832917.jpg!size.m";
        String name = "test.jpg";
        try {
            download(urlString, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======下载成功=====");
    }

    public static void download(String urlString, String fileName) throws Exception {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        InputStream is = null;
        try {
            is = url.openStream();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        OutputStream os = null;
        File f = new File("d:\\picture");
        f.mkdirs();
        try {
            os = new FileOutputStream("d:\\picture\\" + fileName);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void test(){
        String localUrl = "D://123//46//555//56.jpg";
        String pathName = localUrl.substring(0,localUrl.lastIndexOf("//"));
        System.out.println(pathName);
    }


    @Test
    public void test2() throws Exception {
        System.out.println("程序开始······");
        try {
            int i = 1 /0;
        } catch (Exception e) {
//            throw new RuntimeException("数字i计算发现异常······");
            e.printStackTrace();
        }
        int j = 2 ;
//        throw new IOException("数字j计算发现异常······");
       System.out.println("程序结束");
    }

    @Test
    public void test3(){
        File file = new File("D:\\picture\\test.jpg");
        boolean delete = file.delete();
        System.out.println(delete);
    }
}
