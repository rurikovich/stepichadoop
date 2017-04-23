package cs_algo_theory_and_practice_methods_2.task1;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 21.04.2017.
 */
public class CsAlgo2_1_2__3Test {


    @Test
    public void processtasks() throws Exception {
        //test
        assertEquals(asList(), CsAlgo2_1_2__3.processtasks(1, 0, asList()));

        assertEquals(asList(0l), CsAlgo2_1_2__3.processtasks(1, 1, asList(0, 0)));

        assertEquals(asList(0l), CsAlgo2_1_2__3.processtasks(1, 1, asList(0, 1)));

        assertEquals(asList(0l, 3l, -1l, 5l), CsAlgo2_1_2__3.processtasks(2, 4, asList(0, 3, 1, 2, 2, 1, 4, 3)));

        assertEquals(asList(0l, 7l, 7l, -1l, -1l, -1l), CsAlgo2_1_2__3.processtasks(3, 6, asList(0, 7, 0, 0, 2, 0, 3, 3, 4, 0, 5, 0)));

        assertEquals(asList(0l, 2l, 2l, 3l, 4l, 5l), CsAlgo2_1_2__3.processtasks(2, 6, asList(0, 2, 0, 0, 2, 0, 3, 0, 4, 0, 5, 0)));

        assertEquals(asList(0l, 0l), CsAlgo2_1_2__3.processtasks(1, 2, asList(0, 0, 0, 0)));
    }

}