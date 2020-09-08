package charCoding;

import java.io.*;

//转换文件编码，从 GBK 到 UTF-8
//用上缓冲区和字符数组接收
public class Demo04EncodingConverse {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day24\\src\\charCoding\\gbk.txt"), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day24\\src\\charCoding\\utf-8.txt"));
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);
        int len = 0;
        char[] chars = new char[1024];
        while ((len = br.read(chars)) != -1) {
            bw.write(chars, 0, len);
            bw.flush();
        }
        bw.close();
        br.close();
        long e = System.currentTimeMillis();
        System.out.println("执行时间" + (e - s) + "ms");
    }
}
