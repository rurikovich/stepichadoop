package task5_2;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop5_2__3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String v_w = reader.nextLine();
        int nV = Integer.parseInt(v_w.split(" ")[0]);
        int nW = Integer.parseInt(v_w.split(" ")[1]);

//        int v[] = new int[]{};
        int w[][] = new int[][]{};

        for (int ii = 0; ii < nW; ii++) {
            String wLine = reader.nextLine();
            String[] arr = wLine.split(" ");
            int i = Integer.parseInt(arr[0]);
            int j = Integer.parseInt(arr[1]);
            int weight = Integer.parseInt(arr[2]);
            w[i][j] = weight;
        }
        String start_end = reader.nextLine();

        int start = Integer.parseInt(start_end.split(" ")[0]);
        int end = Integer.parseInt(start_end.split(" ")[1]);


    }

}
