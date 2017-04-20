package cs_algo_theory_and_practice_methods_2.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by User on 18.04.2017.
 */
public class CsAlgo2_1__2Test {

    @Test
    public void checkStr() throws Exception {
        CsAlgo2_1__2 csAlgo2_1__2 = new CsAlgo2_1__2();

        assertEquals(0, csAlgo2_1__2.checkStr("([](){([])})"));
        assertEquals(5, csAlgo2_1__2.checkStr("()[]}"));
        assertEquals(7, csAlgo2_1__2.checkStr("{{[()]]"));
        assertEquals(4, csAlgo2_1__2.checkStr("{{[("));
        assertEquals(0, csAlgo2_1__2.checkStr(""));
        assertEquals(3, csAlgo2_1__2.checkStr("()({}"));
    }
}