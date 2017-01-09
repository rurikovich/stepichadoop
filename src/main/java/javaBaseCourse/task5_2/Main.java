package javaBaseCourse.task5_2;

import java.io.ByteArrayInputStream;
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


//        byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
//        System.setIn(inputStream);

        int r = 13;
        int n = 10;

        try (InputStream in = System.in;
             OutputStream out = System.out) {
            int prev = in.read();
            if(prev==-1){
                return;
            }
            int cur = in.read();

            while (cur > 0) {
                if (!(prev == r && cur == n)) {
                    out.write(prev);
                }
                prev = cur;
                cur = in.read();
            }
            out.write(prev);
        }
        System.out.flush();
    }
}
