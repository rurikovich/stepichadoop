package cs_algo_theory_and_practice_methods_2.task3;

import org.junit.Test;

import static cs_algo_theory_and_practice_methods_2.task3.CsAlgo2_3_3.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 06.05.2017.
 */
public class CsAlgo2_3_3Test {

    @Test
    public void findPatternIndexes() throws Exception {
        assertEquals(asList(4, 0), CsAlgo2_3_3.findPatternIndexes("aba", "abacaba"));

        assertEquals(asList(4), CsAlgo2_3_3.findPatternIndexes("Test", "testTesttesT"));

        assertEquals(asList(3, 2, 1), CsAlgo2_3_3.findPatternIndexes("aaaaa", "baaaaaaa"));
    }

    @Test
    public void getNextHashTest() throws Exception {
        int p = 19;
        int x = 7;

        String str = "abcd";
        int n = 2 ;
        long x_pow_n_mod_p = x_pow_n_mod_p(1, x, n, p);

        long hash = h(str.substring(1, str.length()), p, x);

        int lastCharCode = (int) str.charAt(str.length() - 1);
        int firstCharCode = (int) str.charAt(0);
        long nextHash = getNextHash(hash, x, p, x_pow_n_mod_p, lastCharCode, firstCharCode);

        long realNextHash = h(str.substring(0, str.length() - 1), p, x);

        assertEquals(realNextHash, nextHash);
    }

}