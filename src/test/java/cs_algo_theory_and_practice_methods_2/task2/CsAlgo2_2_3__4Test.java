package cs_algo_theory_and_practice_methods_2.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static cs_algo_theory_and_practice_methods_2.task2.CsAlgo2_2_3__4.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 30.04.2017.
 */
public class CsAlgo2_2_3__4Test {
    @Test
    public void processNumberSystem() throws Exception {

        assertEquals(1, CsAlgo2_2_3__4.processNumberSystem(4,
                toOperation(asList(
                        1, 2,
                        1, 3,
                        1, 4,
                        2, 3,
                        2, 4,
                        3, 4)),
                toOperation(asList(
                ))));

        assertEquals(0, CsAlgo2_2_3__4.processNumberSystem(6,
                toOperation(asList(
                        2, 3,
                        1, 5,
                        2, 5,
                        3, 4,
                        4, 2)),
                toOperation(asList(
                        6, 1,
                        4, 6,
                        4, 5
                ))));

        assertEquals(0, CsAlgo2_2_3__4.processNumberSystem(4,
                toOperation(asList(
                        1, 2,
                        1, 3,
                        1, 4,
                        2, 3,
                        2, 4,
                        3, 4)),
                toOperation(asList(
                        1, 2
                ))));

        assertEquals(1, CsAlgo2_2_3__4.processNumberSystem(4,
                toOperation(asList(
                       )),
                toOperation(asList(
                        1, 2,
                        1, 3,
                        1, 4,
                        2, 3,
                        2, 4,
                        3, 4
                ))));

    }

    static List<Operation> toOperation(List<Integer> values) {
        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < values.size(); i += 2) {
            operations.add(new Operation(values.get(i), values.get(i + 1)));
        }
        return operations;
    }

}