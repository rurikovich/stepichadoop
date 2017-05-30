package cs_algo_theory_and_practice_methods_2.task4;

import org.junit.Test;

import static cs_algo_theory_and_practice_methods_2.task4.SplayTreeTask.SplayTree;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by rurik on 30/05/17.
 */
public class SplayTreeTaskTest {

    @Test
    public void testTree() {
        SplayTreeTask splayTreeTask = new SplayTreeTask();

        SplayTree tree = new SplayTree();

//        assertEquals(
//                asList("Not found",
//                        "Found",
//                        "3",
//                        "Found",
//                        "Not found",
//                        "1",
//                        "Not found",
//                        "10"),
//                splayTreeTask.processCommands(tree,
//                        asList("? 1",
//                                "+ 1",
//                                "? 1",
//                                "+ 2",
//                                "s 1 2",
//                                "+ 1000000000",
//                                "? 1000000000",
//                                "- 1000000000",
//                                "? 1000000000",
//                                "s 999999999 1000000000",
//                                "- 2",
//                                "? 2",
//                                "- 0",
//                                "+ 9",
//                                "s 0 9")
//                )
//        );

        assertEquals(
                asList("Not found",
                        "Found",
                        "Not found"),
                splayTreeTask.processCommands(tree,
                        asList("? 0",
                                "+ 0",
                                "? 0",
                                "- 0",
                                "? 0")
                )
        );

//        assertEquals(
//                asList("Found",
//                        "Not found",
//                        "491572259"),
//                splayTreeTask.processCommands(tree,
//                        asList("+ 491572259",
//                                "? 491572259",
//                                "? 899375874",
//                                "s 310971296 877523306",
//                                "+ 352411209")
//                )
//        );

    }

}