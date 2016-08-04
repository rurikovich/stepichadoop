package hadoop.task4_1;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_1__9 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] keyValue = line.split("\t");

            Integer f = Integer.parseInt(keyValue[0]);
            String[] gArr = keyValue[1].split(",");

            for (String g : gArr) {
                System.out.println(f + "," + g + "\t" + 1);
            }
        }
    }


}
