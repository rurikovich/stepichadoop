package hadoop.task4_2;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_2__3 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] items = line.split("\t");
            System.out.println(items[2]);
        }
    }

}
