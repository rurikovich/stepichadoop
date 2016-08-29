package cs_algo_theory_and_practice_methods.task5_5;

import java.util.*;


public class CsAlgo5_5__6 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        ArrayList<Integer> aArr = new ArrayList<>();
        ArrayList<Integer> bArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aArr.add(reader.nextInt());
            bArr.add(reader.nextInt());
        }

        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            points.add(reader.nextInt());
        }

        List<Integer> res = new CsAlgo5_5__6().process(aArr, bArr, points);
        res.forEach(System.out::print);
    }

    List<Integer> process(List<Integer> aArr, List<Integer> bArr, List<Integer> points) {
        return null;
    }

    List<Integer> quickSort(List<Integer> arr) {


        return null;
    }


}
