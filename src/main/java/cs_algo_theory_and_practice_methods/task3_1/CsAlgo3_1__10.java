package cs_algo_theory_and_practice_methods.task3_1;

import javafx.util.Pair;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo3_1__10 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int ww = reader.nextInt();

        ArrayList<Pair<Integer, Integer>> things = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int c = reader.nextInt();
            int w = reader.nextInt();
            things.add(new Pair(c, w));
        }
        Double res = process(ww, things);
        DecimalFormat df = new DecimalFormat(".###");
        System.out.println(df.format(res));
    }

    public static Double process(int ww, ArrayList<Pair<Integer, Integer>> things) {
        things.sort((Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> getCostPerWeight(p2).compareTo(getCostPerWeight(p1)));
        Double cost = 0d;
        int myWW = 0;
        for (Pair<Integer, Integer> th : things) {
            if (myWW + th.getValue() <= ww) {
                myWW += th.getValue();
                cost += th.getKey();
            } else if (myWW < ww) {
                double freeWW = ww - myWW;
                cost += th.getKey() * (freeWW / th.getValue());
                myWW += freeWW;
            }
        }
        return cost;
    }

    private static Double getCostPerWeight(Pair<Integer, Integer> p1) {
        return new Double(p1.getKey()) / p1.getValue();
    }


}
