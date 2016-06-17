package task4_3;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_3__3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;
        String prevKey = "";

        int counter = 0;
        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] items = line.split("\t");
            String key = items[0];
            if (prevKey.equals("") || prevKey.equals(key)) {
                counter++;
            } else {
                String[] keyParts = prevKey.split("#");
                System.out.println(keyParts[0] + "\t" + keyParts[1] + "\t" + counter);
                counter = 1;
            }
            prevKey = key;
        }
        String[] keyParts = prevKey.split("#");
        System.out.println(keyParts[0] + "\t" + keyParts[1] + "\t" + counter);
    }

}
