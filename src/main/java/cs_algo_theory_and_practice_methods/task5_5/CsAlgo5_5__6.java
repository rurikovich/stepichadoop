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
        quickSort(arr, 0, arr.size() - 1);
        return arr;
    }

    void quickSort(List<Integer> arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        quickSort(arr, l, m - 1);
        quickSort(arr, m + 1, r);
    }


    public int partition(List<Integer> arr, int l, int r) {
        int x = arr.get(l);
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            int current = arr.get(i);
            if (current <= x) {
                arr.set(i, arr.get(j + 1));
                arr.set(j + 1, current);
                j++;
            }
        }
        arr.set(l, arr.get(j));
        arr.set(j, x);
        return j;
    }


}
