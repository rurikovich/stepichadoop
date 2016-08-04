package hadoop.task4_2;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_2__6 {

    public static final String INIT_VALUE = "";
    public static final String A = "A";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;
        String prevValue = INIT_VALUE;
        String prevGroup = INIT_VALUE;

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] items = line.split("\t");
            String value = items[0];
            String group = items[1];


            if (!isFirst(prevValue) && !isPrev(prevValue, value) && prevGroup.equals(A)) {
                System.out.println(prevValue);
            }
            prevValue = value;
            prevGroup = group;
        }

        if (prevGroup.endsWith(A)) {
            System.out.println(prevValue);
        }

    }

    private static boolean isPrev(String prevValue, String value) {
        return prevValue.equals(value);
    }

    private static boolean isFirst(String prevValue) {
        return prevValue.equals(INIT_VALUE);
    }

}
