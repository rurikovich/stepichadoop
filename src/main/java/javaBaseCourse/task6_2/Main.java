package javaBaseCourse.task6_2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by rurik on 10.01.2017.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> dequeue = new ArrayDeque<>();

        int counter = 0;
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (counter % 2 != 0) {
                dequeue.add(i);
            }
            counter++;
        }
        while (!dequeue.isEmpty()) {
            System.out.print(dequeue.pollLast()+" ");
        }
    }


}
