package cs_algo_theory_and_practice_methods_2.task3;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @author RastegaevYO
 */
public class CsAlgo2_3_1Test {
    @Test
    public void processRequests() throws Exception {

        assertEquals(
              asList("Mom",
                    "not found",
                    "police",
                    "not found",
                    "Mom",
                    "daddy"
              ), CsAlgo2_3_1_direct_table.processRequests(new String[]{
                    "add 911 police",
                    "add 76213 Mom",
                    "add 17239 Bob",
                    "find 76213",
                    "find 910",
                    "find 911",
                    "del 910",
                    "del 911",
                    "find 911",
                    "find 76213",
                    "add 76213 daddy",
                    "find 76213"
              }));

        assertEquals(
              asList(
                    "not found",
                    "granny",
                    "me",
                    "not found"
              ), CsAlgo2_3_1_direct_table.processRequests(new String[]{
                    "find 3839442",
                    "add 123456 me",
                    "add 0 granny",
                    "find 0",
                    "find 123456",
                    "del 0",
                    "del 0",
                    "find 0"
              }));

        assertEquals(
              asList(
                    "not found",
                    "not found",
                    "not found",
                    "not found",
                    "not found"
              ), CsAlgo2_3_1_direct_table.processRequests(new String[]{
                    "find 3839442",
                    "find 3839442",
                    "find 3839442",
                    "find 3839442",
                    "find 3839442"
              }));


        assertEquals(
              asList(
                    "me",
                    "WEST"
              ), CsAlgo2_3_1_direct_table.processRequests(new String[]{
                    "add 123456 me",
                    "find 123456",
                    "add 123456 WEST",
                    "find 123456",
              }));

        assertEquals(
              asList(

              ), CsAlgo2_3_1_direct_table.processRequests(new String[]{

              }));

    }

}