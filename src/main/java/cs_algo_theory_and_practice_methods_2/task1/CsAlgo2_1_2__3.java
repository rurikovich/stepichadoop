package cs_algo_theory_and_practice_methods_2.task1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_1_2__3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int size = reader.nextInt();
        int n = reader.nextInt();

        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input.add(reader.nextInt());
            input.add(reader.nextInt());
        }

        List<Long> output = processtasks(size, n, input);
        output.forEach(System.out::println);
    }

    static List<Long> processtasks(int size, int n, List<Integer> input) {
        List<Task> output = new ArrayList<>();
        Queue<Task> queue = new LinkedList();

        long proccessorWillBeFree = 0;
        for (int i = 0; i < 2 * n; i += 2) {
            int arrival = input.get(i);
            int duration = input.get(i + 1);
            Task task = new Task(arrival, duration);


            while (!queue.isEmpty() && proccessorWillBeFree <= task.arrival) {
                queue.poll();
                proccessorWillBeFree = processNextTask(output, queue, proccessorWillBeFree);
            }

            if (queryIsNotFull(size, queue)) {
                if (queue.isEmpty()) {
                    proccessorWillBeFree = task.arrival + task.duration;
                    task.processStartTime = Long.valueOf(task.arrival);
                    output.add(task);
                }
                queue.offer(task);
            } else {
                task.processStartTime = -1l;
                output.add(task);
            }
        }

        while (!queue.isEmpty()) {
            queue.poll();
            proccessorWillBeFree = processNextTask(output, queue, proccessorWillBeFree);
        }

        Collections.sort(output, (o1, o2) -> o1.arrival.compareTo(o2.arrival));
        return output.stream().map(task -> task.processStartTime).collect(Collectors.toList());
    }

    private static boolean queryIsNotFull(int size, Queue<Task> queue) {
        return queue.size() < size;
    }

    private static long processNextTask(List<Task> output, Queue<Task> queue, long proccessorWillBeFree) {
        Task next = queue.peek();
        if (next != null) {
            next.processStartTime = proccessorWillBeFree;
            output.add(next);
            proccessorWillBeFree += next.duration;
        }
        return proccessorWillBeFree;
    }

    private static class Task {
        private Integer arrival;
        private Integer duration;
        private Long processStartTime;

        public Task(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
        }

    }
}
