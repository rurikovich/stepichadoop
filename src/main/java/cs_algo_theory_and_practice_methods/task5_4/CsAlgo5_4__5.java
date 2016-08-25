package cs_algo_theory_and_practice_methods.task5_4;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo5_4__5 {

    private int invCount = 0;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(reader.nextInt());
        }

        int inv = new CsAlgo5_4__5().process(arr);
        System.out.print(inv);
    }

    int process(ArrayList<Integer> arr) {
        List<Integer> res = getSortedArr(arr);
        return invCount;
    }

    private List<Integer> getSortedArr(ArrayList<Integer> arr) {
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < arr.size(); i++) {
            queue.offer(arr.subList(i, i + 1));
        }
        while (queue.size() > 1) {
            List<Integer> merge = merge(queue.poll(), queue.poll());
            queue.offer(merge);
        }
        return queue.poll();
    }


    List<Integer> merge(List<Integer> lArr, List<Integer> rArr) {
        if (lArr.isEmpty()) {
            return rArr;
        }
        if (rArr.isEmpty()) {
            return lArr;
        }

        int n = lArr.size() + rArr.size();
        ArrayList<Integer> resArr = new ArrayList<>();

        int lIndex = 0;
        int rIndex = 0;
        for (int i = 0; i < n; i++) {
            int l = lArr.get(lIndex);
            int r = rArr.get(rIndex);
            if (l < r) {
                resArr.add(l);
                if (isLastIndex(lArr, lIndex)) {
                    List<Integer> tail = getTail(rArr, rIndex);
                    resArr.addAll(tail);
                    invCount += tail.size();
                    return resArr;
                } else {
                    lIndex++;
                }
            } else {
                resArr.add(r);
                invCount++;
                if (isLastIndex(rArr, rIndex)) {
                    resArr.addAll(getTail(lArr, lIndex));
                    return resArr;
                } else {
                    rIndex++;
                }
            }
        }
        return resArr;
    }

    private List<Integer> getTail(List<Integer> rArr, int rIndex) {
        return rArr.subList(rIndex, rArr.size());
    }

    private boolean isLastIndex(List<Integer> lArr, int lIndex) {
        return lIndex == lArr.size() - 1;
    }


}
