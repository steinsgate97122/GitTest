package charCoding;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo01OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day24\\src\\charCoding\\gbk.txt"), "gbk");
        osw.write("你好");
        osw.flush();
        osw.close();
    }
}
