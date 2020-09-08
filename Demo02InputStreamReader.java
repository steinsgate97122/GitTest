package charCoding;

import java.io.*;

public class Demo02InputStreamReader {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day24\\src\\charCoding\\gbk.txt"),"gbk");
        int len = 0;
        while((len=isr.read())!=-1){
            System.out.print((char)len);
        }
        isr.close();
    }
}
