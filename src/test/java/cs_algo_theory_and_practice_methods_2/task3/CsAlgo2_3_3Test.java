package cs_algo_theory_and_practice_methods_2.task3;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 06.05.2017.
 */
public class CsAlgo2_3_3Test {
    @Test
    public void findPatternIndexes() throws Exception {
        assertEquals(asList(4,0), CsAlgo2_3_3.findPatternIndexes("aba", "abacaba"));

//        assertEquals(asList(4), CsAlgo2_3_3.findPatternIndexes("Test", "testTesttesT"));
//
//        assertEquals(asList(3, 2, 1), CsAlgo2_3_3.findPatternIndexes("aaaaa", "baaaaaaa"));
    }

}