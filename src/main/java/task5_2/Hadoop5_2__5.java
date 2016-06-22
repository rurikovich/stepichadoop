package task5_2;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop5_2__5 {

    public static final int MAX = Integer.MAX_VALUE / 2;
    private static final String TAB = "\t";
    public static final String INF = "INF";

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
//        for (int ii = 0; ii < 10; ii++) {
            String line = reader.nextLine();
            String[] data = line.split(TAB);
            String key = data[0];
            String distance = data[1];
            String arr = data[2].replace("{", "").replace("}", "");

            System.out.println(line);

            if(!arr.isEmpty()){
                String[] vertexes = arr.split(",");
                for (int i = 0; i < vertexes.length; i++) {
                    String v = vertexes[i];
                    if (distance.equals(INF)) {
                        System.out.println(v + TAB + INF + TAB + "{}");
                    } else {
                        System.out.println(v + TAB + (Integer.parseInt(distance) + 1) + TAB + "{}");
                    }
                }
            }
        }


    }

}
