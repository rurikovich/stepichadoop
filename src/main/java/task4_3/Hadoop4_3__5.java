package task4_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_3__5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;
        String prevKey = "";

        int counter = 0;
        List<String> values = new ArrayList<>();
        while (reader.hasNext()) {

            line = reader.nextLine();
            String[] items = line.split("\t");
            String key = items[0];
            String value = items[1];

            if (prevKey.equals("") || prevKey.equals(key)) {
                counter++;
            } else {
                for (String v : values) {
                    System.out.println(prevKey + "#" + v.split(";")[0] + "\t" + v.split(";")[1] + "\t" + counter);
                }
                values.clear();
                counter = 1;
            }
            values.add(value);
            prevKey = key;
        }
        for (String v : values) {
            System.out.println(prevKey + "#" + v.split(";")[0] + "\t" + v.split(";")[1] + "\t" + counter);
        }

    }

}
