package hadoop.task5_3;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop5_3__8 {

    public static final int MAX = Integer.MAX_VALUE / 2;
    private static final String TAB = "\t";

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);

        Scanner reader = new Scanner(System.in);
//        while (reader.hasNext()) {
        for (int ii = 0; ii < 5; ii++) {
            String line = reader.nextLine();
            String[] data = line.split(TAB);

            String key = data[0];
            String weight = data[1];
            String vertexes = data[2].replace("{", "").replace("}", "");

            System.out.println(line);

            if (!vertexes.isEmpty()) {
                String[] vArr = vertexes.split(",");
                Double p = Double.parseDouble(weight) / vArr.length;
                for (int i = 0; i < vArr.length; i++) {
                    Integer v = Integer.parseInt(vArr[i]);
                    System.out.println(v + TAB + formatTo5Length(df.format(p)) + TAB + "{}");
                }
            }
        }


    }

    private static String formatTo5Length(String s) {
        String res=s;
        int n = 5 - s.length();
        for (int i = 0; i < n; i++) {
            res+="0";
        }
        return res;
    }


}
