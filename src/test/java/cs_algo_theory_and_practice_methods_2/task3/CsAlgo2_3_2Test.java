package cs_algo_theory_and_practice_methods_2.task3;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 04.05.2017.
 */
public class CsAlgo2_3_2Test {
    @Test
    public void processRequests() throws Exception {
        assertEquals(
                asList("HellO world",
                        "no",
                        "yes",
                        "HellO",
                        "GooD luck"),
                CsAlgo2_3_2.processRequests(5,
                        new String[]{"add world",
                                "add HellO",
                                "check 4",
                                "find World",
                                "find world",
                                "del world",
                                "check 4",
                                "del HellO",
                                "add luck",
                                "add GooD",
                                "check 2",
                                "del good"}
                )
        );

        assertEquals(
                asList("yes",
                        "no",
                        "no",
                        "yes"),
                CsAlgo2_3_2.processRequests(4,
                        new String[]{
                                "add test",
                                "add test",
                                "find test",
                                "del test",
                                "find test",
                                "find Test",
                                "add Test",
                                "find Test"}
                )
        );

        assertEquals(
                asList("",
                        "no",
                        "yes",
                        "yes",
                        "no",
                        "",
                        "add help",
                        ""),
                CsAlgo2_3_2.processRequests(3,
                        new String[]{"check 0",
                                "find help",
                                "add help",
                                "add del",
                                "add add",
                                "find add",
                                "find del",
                                "del del",
                                "find del",
                                "check 0",
                                "check 1",
                                "check 2"}
                )
        );

    }

    @Test
    public void h() throws Exception {
        assertEquals(4, CsAlgo2_3_2.h("world", 5));
        assertEquals(4, CsAlgo2_3_2.h("HellO", 5));
    }

    @Test
    public void listToString() throws Exception {
        assertEquals("", CsAlgo2_3_2.listToString(asList()));
        assertEquals("3 2 1", CsAlgo2_3_2.listToString(asList("1", "2", "3")));
    }
}