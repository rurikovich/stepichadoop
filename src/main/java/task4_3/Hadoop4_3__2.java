package task4_3;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_3__2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;

        while (reader.hasNext()) {
            line = reader.nextLine();
            line.replaceAll("\\W|\t"," ");
            line.trim();
            String[] items = line.split("(\\s|:)+");
            String docNumber = items[0];
            for (int i = 1; i < items.length; i++) {
                System.out.println(items[i] + "#" + docNumber + "\t" + 1);
            }
        }


    }

}
