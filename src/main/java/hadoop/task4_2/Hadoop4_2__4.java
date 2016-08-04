package hadoop.task4_2;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_2__4 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;

        String prev = "";

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] items = line.split("\t");
            String value = items[0];

            if (!prev.equals("") && !value.equals(prev)) {
                System.out.println(prev);
            }
            prev = value;

        }
        System.out.println(prev);
    }

}
