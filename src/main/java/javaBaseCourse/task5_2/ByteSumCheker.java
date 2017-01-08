package javaBaseCourse.task5_2;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by User on 09.01.2017.
 */
public class ByteSumCheker {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int Cn = 0;
        int b = inputStream.read();
        while (b > 0) {
            Cn = Integer.rotateLeft(Cn, 1) ^ b;
            b = inputStream.read();
        }
        return Cn;
    }

}
