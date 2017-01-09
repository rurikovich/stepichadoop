package javaBaseCourse.task5_3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by rurik on 09.01.2017.
 */
public class StringReader {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder sb=new StringBuilder();
        while(true){
            int b = reader.read();
            if(b==-1){
                break;
            }
            sb.append((char)b);
        }
        return sb.toString();
    }

}
