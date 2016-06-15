package task4_1;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_1__14 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] items = line.split(" ");
            for (String a : items) {
                for (String b : items) {
                    if(!a.equals(b)){
                        System.out.println(a + "," + b + "\t" + 1);
                    }
                }
            }
        }


    }
}
