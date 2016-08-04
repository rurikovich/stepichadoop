package hadoop.task4_3;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_3__4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;
        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] items = line.split("\t");
            System.out.println(items[0] + "\t" + items[1] + ";" + items[2] + ";1");
        }
    }

}
