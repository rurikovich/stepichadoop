package javaBaseCourse.task5_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by User on 09.01.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        byte r = 0x13;
//        byte n = 0x10;
        int r = 13;
        int n = 10;

        try (InputStream in = System.in;
             OutputStream out = System.out) {
            int prev = in.read();
            int cur = in.read();

            while (cur > 0) {
                if (!(prev == r && cur == n)) {
                    out.write(prev);
                }
                prev = cur;
                cur = in.read();
            }
        }
        System.out.flush();
    }
}
