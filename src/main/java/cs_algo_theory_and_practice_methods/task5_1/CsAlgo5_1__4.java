package cs_algo_theory_and_practice_methods.task5_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo5_1__4 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ArrayList<Integer> sortedArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedArr.add(reader.nextInt());
        }
        int k = reader.nextInt();
        ArrayList<Integer> arrToTest = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arrToTest.add(reader.nextInt());
        }
        ArrayList<Integer> indexes = process(sortedArr, arrToTest);
        StringBuilder sb = new StringBuilder("");
        indexes.forEach(i -> sb.append(i).append(i != indexes.size() - 1 ? " " : ""));
        System.out.print(sb.toString());
    }

    static ArrayList<Integer> process(ArrayList<Integer> sortedArr, ArrayList<Integer> arrToTest) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (Integer number : arrToTest) {
            Integer index = findIndex(sortedArr, number);
            indexes.add(index);
        }
        return indexes;
    }

    private static Integer findIndex(List<Integer> arr, Integer number) {
        Integer startIndex = 0;
        Integer endIndex = arr.size() - 1;
        if (arr.get(startIndex) > number || arr.get(endIndex) < number) {
            return -1;
        }

        Integer resultIndex = -1;
        while (endIndex - startIndex > 1) {
            Integer middleIndex = (startIndex + endIndex) / 2;
            Integer middleNumber = arr.get(middleIndex);

            if (middleNumber.equals(number)) {
                resultIndex = middleIndex + 1;
                break;
            } else {
                if (middleNumber > number) {
                    endIndex = middleIndex;
                } else {
                    startIndex = middleIndex;
                }
            }
        }

        if (arr.get(startIndex).equals(number)) {
            resultIndex = startIndex + 1;
        }
        if (arr.get(endIndex).equals(number)) {
            resultIndex = endIndex + 1;
        }

        return resultIndex;


    }
}
