package cs_algo_theory_and_practice_methods_2.task3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 04.05.2017.
 */
public class CsAlgo2_3_2Test {
    @Test
    public void processRequests() throws Exception {

    }

    @Test
    public void h() throws Exception {
        assertEquals(4, CsAlgo2_3_2.h("world", 5));
        assertEquals(4, CsAlgo2_3_2.h("hello", 5));
    }

}