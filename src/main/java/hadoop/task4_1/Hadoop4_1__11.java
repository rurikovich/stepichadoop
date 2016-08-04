package hadoop.task4_1;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_1__11 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] keyValue = line.split("\t");
            String fg = keyValue[0];
            String g = fg.split(",")[1];
            System.out.println(g + "\t" + 1);
        }
    }


}
