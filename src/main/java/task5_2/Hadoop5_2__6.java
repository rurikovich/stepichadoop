package task5_2;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop5_2__6 {

    public static final int MAX = Integer.MAX_VALUE / 2;
    private static final String TAB = "\t";
    public static final String INF = "INF";
    public static final Integer INIT_VALUE = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        String prevKey = "";

        Integer minDistance = INIT_VALUE;
        String arrToPrint = "";

        while (reader.hasNext()) {
//        for (int ii = 0; ii < 19; ii++) {
            String line = reader.nextLine();
            String[] data = line.split(TAB);
            String key = data[0];
            String distance = data[1];
            String arr = data[2].replace("{", "").replace("}", "");

            if (!(prevKey.equals("") || key.equals(prevKey))) {
                String d = !minDistance.equals(INIT_VALUE)? minDistance.toString() : INF;
                System.out.println(prevKey + TAB + d + TAB + "{" + arrToPrint + "}");
                minDistance = INIT_VALUE;
                arrToPrint = "";
            }

            prevKey = key;
            if (!distance.equals(INF)) {
                int d = Integer.parseInt(distance);
                if (d < minDistance) {
                    minDistance = d;
                }
            }

            if (!arr.isEmpty()) {
                arrToPrint = arr;
            }


        }

        String d = !minDistance.equals(INIT_VALUE) ? minDistance.toString() : INF;
        System.out.println(prevKey + TAB + d + TAB + "{" + arrToPrint + "}");


    }

}
