package cs_algo_theory_and_practice_methods_2.task1;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_1_2__3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int size = reader.nextInt();
        int n = reader.nextInt();

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(reader.nextInt(), reader.nextInt()));
        }

        if (n != 0) {
            List<Integer> output = processTasks(size, tasks);
            output.forEach(System.out::println);
        }
    }

    static List<Integer> processTasks(int querySize, int n, List<Integer> tasksInts) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 2 * n; i += 2) {
            tasks.add(new Task(tasksInts.get(i), tasksInts.get(i + 1)));
        }
        return processTasks(querySize, tasks);
    }

    private static List<Integer> processTasks(int querySize, List<Task> tasks) {
        LimitedQuery query = new LimitedQuery(querySize);
        Integer nextTimeProcessorWillBeFree = tasks.get(0).arrival;
        for (Task task : tasks) {
            int currentTime = task.arrival;
            nextTimeProcessorWillBeFree = processTaskToCurrentTime(query, currentTime, nextTimeProcessorWillBeFree);
            query.addOrMarkAsFailed(task);
        }

         processTaskToCurrentTime(query, Integer.MAX_VALUE, nextTimeProcessorWillBeFree);

        return tasks.stream().sorted((t1, t2) -> t1.arrival.compareTo(t2.arrival))
                .map(t -> t.startProcessTime).collect(toList());
    }

    private static Integer processTaskToCurrentTime(LimitedQuery query, Integer currentTime, Integer nextTimeProcessorWillBeFree) {
        while (!query.isEmpty()) {
            Task nextTask = query.peek();
            int startTaskTime = Math.max(nextTask.arrival, nextTimeProcessorWillBeFree);
            if (startTaskTime + nextTask.duration <= currentTime) {
                nextTask.startProcessTime = startTaskTime;
                nextTimeProcessorWillBeFree = startTaskTime + nextTask.duration;
                query.poll();
            } else {
                break;
            }
        }
        return nextTimeProcessorWillBeFree;
    }


    static class Task {
        Integer arrival;
        Integer duration;
        Integer startProcessTime;

        public Task(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
        }
    }

    static class LimitedQuery {
        public static final int TASK_FAILED = -1;
        private Queue<Task> queue;
        private int size;

        public LimitedQuery(int size) {
            queue = new LinkedList<>();
            this.size = size;
        }

        public boolean addOrMarkAsFailed(Task task) {
            boolean notFull = queue.size() < size;
            if (notFull) {
                queue.add(task);
            } else {
                task.startProcessTime = TASK_FAILED;
            }
            return notFull;
        }

        public Task poll() {
            return queue.poll();
        }

        public Task peek() {
            return queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

}
