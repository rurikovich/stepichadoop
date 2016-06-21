package task5_2;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop5_2__3 {

    public static final int MAX = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {

        //---------------- input reading------------------------
        Scanner reader = new Scanner(System.in);
        String v_w = reader.nextLine();
        int nV = Integer.parseInt(v_w.split(" ")[0]);
        int nW = Integer.parseInt(v_w.split(" ")[1]);

//        int v[] = new int[nV];
        int w[][] = new int[nV][nV];

        for (int ii = 0; ii < nW; ii++) {
            String wLine = reader.nextLine();
            String[] arr = wLine.split(" ");
            int i = Integer.parseInt(arr[0]);
            int j = Integer.parseInt(arr[1]);
            int weight = Integer.parseInt(arr[2]);
            w[i - 1][j - 1] = weight;
        }
        String start_end = reader.nextLine();

        int start = Integer.parseInt(start_end.split(" ")[0]) - 1;
        int end = Integer.parseInt(start_end.split(" ")[1]) - 1;
        //---------------- input reading------------------------


        //---------------- init------------------------
        int d[] = new int[nV];
        for (int i = 0; i < nV; i++) {
            d[i] = 0;
        }
        d[start] = 0;


        Set<Integer> q = new HashSet<>();
        for (int i = 0; i < nV; i++) {
            if (i != start) {
                q.add(i);
            }
        }
        List<Integer> processedV = new ArrayList<>();
        processedV.add(start);
        //---------------- init------------------------


        while (!q.isEmpty()) {
            int minWeight = MAX;
            int minI = 0;
            int minJ = 0;

            for (Integer pV : processedV) {
                for (int j = 0; j < nV; j++) {
                    if (!processedV.contains(j)) {
                        int value = w[pV][j];
                        if (value != 0 && value < minWeight) {
                            minWeight = value;
                            minI = pV;
                            minJ = j;
                        }
                    }

                }
            }

            if (minWeight != MAX) {
                d[minJ] = d[minI] + minWeight;
                processedV.add(minJ);
                q.remove(minJ);
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(d[end] == 0 ? -1 : d[end]);

    }

}
