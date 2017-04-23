package cs_algo_theory_and_practice_methods_2.task1;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 23.04.2017.
 */
public class CsAlgo2_1_2__5Test {
    @Test
    public void getMaxs() throws Exception {
        assertEquals(asList(7, 7, 5, 6, 6), CsAlgo2_1_2__5.getMaxs(8, new int[]{2, 7, 3, 1, 5, 2, 6, 2}, 4));
        assertEquals(asList(2, 1, 5), CsAlgo2_1_2__5.getMaxs(3, new int[]{2, 1, 5}, 1));
        assertEquals(asList(9), CsAlgo2_1_2__5.getMaxs(3, new int[]{2, 3, 9}, 3));
    }

}