package cs_algo_theory_and_practice_methods.task3_1;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo3_1__9 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        ArrayList<Pair<Integer, Integer>> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = reader.nextInt();
            int r = reader.nextInt();
            segments.add(new Pair(l, r));
        }
        ArrayList<Integer> res = process(segments);
        System.out.println(res.size());
        for (Integer re : res) {
            System.out.println(re);
        }
    }

    public static ArrayList<Integer> process(ArrayList<Pair<Integer, Integer>> segments) {
        segments.sort((Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> p1.getValue().compareTo(p2.getValue()));

        ArrayList<Integer> points = new ArrayList<>();
        for (Pair<Integer, Integer> s : segments) {
            if (!segmentsContainsPoints(s, points)) {
                points.add(s.getValue());
            }
        }


        return points;
    }

    private static boolean segmentsContainsPoints(Pair<Integer, Integer> s, ArrayList<Integer> points) {
        for (Integer p : points) {
            if (p >= s.getKey() && p <= s.getValue()) {
                return true;
            }
        }
        return false;
    }


}
