package task4_2;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_2__7 {
    public static final String INIT_VALUE = "";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;
        String prevValue = INIT_VALUE;
        Boolean isPrevIntersepted = false;

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] items = line.split("\t");
            String value = items[0];

            if (!isFirst(prevValue)) {
                if (!isPrev(prevValue, value)) {
                    if (!isPrevIntersepted) {
                        System.out.println(prevValue);
                    } else {
                        isPrevIntersepted = false;
                    }
                } else {
                    isPrevIntersepted = true;
                }
            }
            prevValue = value;
        }
        if(!isPrevIntersepted){
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
