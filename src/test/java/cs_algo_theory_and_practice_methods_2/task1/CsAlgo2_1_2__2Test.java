package cs_algo_theory_and_practice_methods_2.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 23.04.2017.
 */
public class CsAlgo2_1_2__2Test {
    @Test
    public void treeHeight() throws Exception {
        assertEquals(4, CsAlgo2_1_2__2.processTree(10, new int[]{9, 7, 5, 5, 2, 9, 9, 9, 2, -1}));
        assertEquals(3, CsAlgo2_1_2__2.processTree(5, new int[]{4, -1, 4, 1, 1}));
        assertEquals(4, CsAlgo2_1_2__2.processTree(5, new int[]{-1, 0, 4, 0, 3}));
    }
}