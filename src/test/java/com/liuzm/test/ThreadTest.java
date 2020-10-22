package com.liuzm.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ThreadTest {

    @Test
    public void test1() {
        File f = new File("D://picture//10000001//1001949//00//181996301111.jpg");
        if (f.exists()) {
            System.out.println("=========true=======");
        }

    }


    public static void downloadPicture(String spUrl, String localUrl) throws IOException {
        File f = new File("D://picture//10000001//1001949//00");
        String spUrlMd5 = null;
        if (!f.exists()) {
            boolean mkdirs = f.mkdirs();
            if (!mkdirs) {
                throw new IOException("创建文件夹失败");
            }
        }
        URL url = new URL(spUrl);
        InputStream is = url.openStream();
        OutputStream os = null;
//        spUrlMd5 = DigestUtils.md5Hex(is);
//        System.out.println("spUrlMd5 = " + spUrlMd5);

        try {
            os = new FileOutputStream(localUrl);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }


        } catch (IOException e) {
            throw new IOException("下载图片失败");
        } finally {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
        }

        String localUrlMd5 = DigestUtils.md5Hex(new FileInputStream(localUrl));
        System.out.println("localUrlMd5 = " + localUrlMd5);
    }

    @Test
    public void test() throws Exception {
        String spUrl = "http://dimg04.c-ctrip.com/images//200l170000011je5jFCC5_R_550_412.jpg";
        String localUrl = "D://picture//10000001//1001949//00//18199630.jpg";
        URL url = new URL(spUrl);
        InputStream is = url.openStream();
        String s1 = DigestUtils.md5Hex(is);
        String s2 = DigestUtils.md5Hex(new FileInputStream(localUrl));
        System.out.println(s1.equals(s2));
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        //bdaa41d77570631b6e80205055abba2c
    }


    private void testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new ArithmeticException("算术异常");
        }
        System.out.println("继续执行程序！");
    }

    public static void main(String[] args) throws Exception {
        String ss = "https://pics3.baidu.com/feed/5243fbf2b21193135eca4dc7ecd86bd090238d20.jpeg?token=866c0b0773210dd175c200be162d3a06";
        URL url = new URL(ss);
        InputStream is = url.openStream();

//        byte[] bytes = toByteArray(is);
        String s1 = DigestUtils.md5Hex(is);
        String s2 = DigestUtils.md5Hex(is);
        String s3 = DigestUtils.md5Hex(is);
        String s4 = DigestUtils.md5Hex(is);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }


    private static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }


    public void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
        String separator = File.separator;
        System.out.println(separator + "--------------------------");
        File file = new File(savePath + "//" + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos != null) {
            fos.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }


        System.out.println("info:" + url + " download success");

    }


    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    @Test
    public void test9() {
        try {
            downLoadFromUrl("http://dimg04.c-ctrip.com/images//200l170000011je5jFCC5_R_550_412.jpg", "18199630.jpg", "D:\\picture\\10000001\\1001949\\00");
        } catch (Exception e) {
            System.out.println("e = " + e.toString());
            System.out.println("123");
        }
    }

    @Test
    public void pictureCompare() {
        File file = new File("D://picture//10000001//1001949//00//18199630.jpg");

        boolean exists = file.exists();
        System.out.println(exists);
    }

    @Test
    public void pictureMd5(){
        String spUrl = "http://dimg04.c-ctrip.com/images//200l170000011je5jFCC5_R_550_412.jpg";
        String localUrl = "D://picture//10000001//1001949//00//18199630.jpg";
        comparePictureMd5(spUrl,localUrl);
    }

    public static void comparePictureMd5(String spUrl, String localUrl) {
        long startTime = System.currentTimeMillis();
        try {
            URL url = new URL(spUrl);
            InputStream is = url.openStream();
            String spUrlMd5 = DigestUtils.md5Hex(is);
            String localUrlMd5 = DigestUtils.md5Hex(new FileInputStream(localUrl));
        } catch (IOException e) {
            System.out.println(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    @Test
    public void testNum() {
        Integer a = 100;
        Integer b = 100;
        Integer a1 = 200;
        Integer b1 = 200;
        System.out.println(a == b);//true
        System.out.println(b1 == a1);//false
    }

}
