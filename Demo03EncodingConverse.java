package charCoding;

import java.io.*;

//转换文件编码，从 GBK 到 UTF-8
public class Demo03EncodingConverse {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day24\\src\\charCoding\\gbk.txt"), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day24\\src\\charCoding\\utf-8.txt"));
        int len = 0;
        while ((len = isr.read()) != -1) {
            osw.write(len);
            osw.flush();
        }
        osw.close();
        isr.close();
        long e = System.currentTimeMillis();
        System.out.println("执行时间" + (e - s) + "ms");
    }
}
