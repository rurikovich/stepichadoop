package cs_algo_theory_and_practice_methods_2.task2;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_2_3__2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();

        Queue<Long> tasks = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            tasks.add(reader.nextLong());
        }
        List<ProcessedTask> processedTasks = processTasks(n, tasks);
        processedTasks.forEach(System.out::println);

    }

    static List<ProcessedTask> processTasks(int n, Queue<Long> tasks) {
        ProcessorTaskMinHeap taskMinHeap = new ProcessorTaskMinHeap(n);

        List<ProcessedTask> processedTasks = new ArrayList<>();
        long[] processTimes = new long[n];
        for (int i = 0; i < n; i++) {
            if (!tasks.isEmpty()) {
                ProcessedTask task = startNewTask(taskMinHeap, tasks, processTimes, i);
                processedTasks.add(task);
            }
        }

        while (!tasks.isEmpty()) {
            ProcessorTask processorTask = taskMinHeap.getMin();
            ProcessedTask task = startNewTask(taskMinHeap, tasks, processTimes, processorTask.processor);
            processedTasks.add(task);
        }
        return processedTasks;
    }

    private static ProcessedTask startNewTask(ProcessorTaskMinHeap taskMinHeap, Queue<Long> tasks, long[] processTimes, int i) {
        ProcessedTask processedTask = new ProcessedTask(i, processTimes[i]);
        Long taskDuration = tasks.poll();
        long newStartTime = processTimes[i] + taskDuration;
        processTimes[i] = newStartTime;
        taskMinHeap.insert(new ProcessorTask(i, newStartTime));
        return processedTask;
    }


    static class ProcessorTaskMinHeap {
        private final int maxHeapsize;
        private int size;
        private ProcessorTask[] arr;


        public ProcessorTaskMinHeap(int n) {
            maxHeapsize = n;
            this.arr = new ProcessorTask[n];
        }

        public ProcessorTask getMin() {
            ProcessorTask res = arr[0];
            swap(arr, 0, size - 1);
            size--;
            pushDown(arr, 0);
            return res;
        }

        public void insert(ProcessorTask value) {
            int last = this.size;
            arr[last] = value;
            pushUp(arr, last);
            this.size++;
        }

        public void setSize(int size) {
            this.size = size;
        }

        void pushUp(ProcessorTask[] arr, int i) {
            int parent = getParent(i);
            if (parent >= 0 && arr[parent].greaterThan(arr[i])) {
                swap(arr, i, parent);
                pushUp(arr, parent);
            }
        }

        private void swap(ProcessorTask[] arr, int i, int j) {
            ProcessorTask temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        void pushDown(ProcessorTask[] arr, int i) {
            int leftChild = getLeft(i);
            int rightChild = getRight(i);

            ArrayList<Integer> indexes = new ArrayList<>();
            indexes.add(i);
            if (leftChild < size) {
                indexes.add(leftChild);
            }
            if (rightChild < size) {
                indexes.add(rightChild);
            }
            int swapIndex = findMinIndex(arr, indexes);
            if (swapIndex == i) {
                return;
            }

            swap(arr, i, swapIndex);
            pushDown(arr, swapIndex);
        }

        private int getParent(int i) {
            return i == 0 ? -1 : (i - 1) / 2;
        }

        private int getLeft(int i) {
            return 2 * i + 1;
        }

        private int getRight(int i) {
            return 2 * i + 2;
        }

        private int findMinIndex(ProcessorTask[] arr, ArrayList<Integer> indexes) {
            int min = indexes.get(0);
            for (int index : indexes) {
                if (arr[min].greaterThan(arr[index])) {
                    min = index;
                }
            }
            return min;
        }


    }

    static class ProcessorTask {
        int processor;
        long taskDuration;

        public ProcessorTask(int processor, long taskDuration) {
            this.processor = processor;
            this.taskDuration = taskDuration;
        }

        public boolean greaterThan(ProcessorTask task) {
            if (this.taskDuration == task.taskDuration) {
                return this.processor > task.processor;
            }
            return this.taskDuration > task.taskDuration;
        }
    }


    static class ProcessedTask {
        int processor;
        long startTime;

        public ProcessedTask(int processor, long startTime) {
            this.processor = processor;
            this.startTime = startTime;
        }

        @Override
        public String toString() {
            return processor + " " + startTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ProcessedTask that = (ProcessedTask) o;

            if (processor != that.processor) return false;
            return startTime == that.startTime;

        }

        @Override
        public int hashCode() {
            int result = processor;
            result = 31 * result + (int) (startTime ^ (startTime >>> 32));
            return result;
        }
    }


}
