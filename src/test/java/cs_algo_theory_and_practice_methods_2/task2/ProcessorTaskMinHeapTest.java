package cs_algo_theory_and_practice_methods_2.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static cs_algo_theory_and_practice_methods_2.task2.CsAlgo2_2_3__2.ProcessedTask;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 28.04.2017.
 */
public class ProcessorTaskMinHeapTest {


    @Test
    public void processTasks() throws Exception {

        assertEquals(
                toProcessedTaskList(
                        0, 0,
                        1, 0,
                        0, 1,
                        1, 2,
                        0, 4), CsAlgo2_2_3__2.processTasks(2, new LinkedList<>(asList(1l, 2l, 3l, 4l, 5l))));

        assertEquals(
                toProcessedTaskList(
                        0, 0,
                        1, 0,
                        2, 0,
                        3, 0,
                        0, 1,
                        1, 1,
                        2, 1,
                        3, 1,
                        0, 2,
                        1, 2,
                        2, 2,
                        3, 2,
                        0, 3,
                        1, 3,
                        2, 3,
                        3, 3,
                        0, 4,
                        1, 4,
                        2, 4,
                        3, 4), CsAlgo2_2_3__2.processTasks(4, new LinkedList<>(asList(1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l))));
    }


    private List<ProcessedTask> toProcessedTaskList(long... list) {
        List<ProcessedTask> tasks = new ArrayList<>();
        for (int i = 0; i < list.length; i += 2) {
            tasks.add(new ProcessedTask((int) list[i], list[i + 1]));
        }
        return tasks;
    }

}