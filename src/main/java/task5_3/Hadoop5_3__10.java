package task5_3;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop5_3__10 {

    private static final String TAB = "\t";
    public static final Integer INIT_VALUE = Integer.MAX_VALUE / 2;
    public static final Double RANDOM_SERFING = 1d / 50;

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.FLOOR);

        Scanner reader = new Scanner(System.in);
        String prevKey = "";


        Double sumWeight = RANDOM_SERFING;
        String arrToPrint = "";

        while (reader.hasNext()) {
//        for (int ii = 0; ii < 14; ii++) {
            String line = reader.nextLine();
            String[] data = line.split(TAB);

            String key = data[0];
            String weight = data[1];
            String vertexes = data[2].replace("{", "").replace("}", "");


            if (!(prevKey.equals("") || key.equals(prevKey))) {
                System.out.println(prevKey + TAB + formatTo5Length(df.format(sumWeight)) + TAB + "{" + arrToPrint + "}");
                sumWeight = RANDOM_SERFING;
                arrToPrint = "";
            }
            if (vertexes.isEmpty()) {
                sumWeight += 0.9 * Double.parseDouble(weight);
            } else {
                arrToPrint = vertexes;
            }
            prevKey = key;
        }
        System.out.println(prevKey + TAB + formatTo5Length(df.format(sumWeight)) + TAB + "{" + arrToPrint + "}");

    }

    private static String formatTo5Length(String s) {
        String res = s;
        int n = 5 - s.length();
        for (int i = 0; i < n; i++) {
            res += "0";
        }
        return res;
    }

}
