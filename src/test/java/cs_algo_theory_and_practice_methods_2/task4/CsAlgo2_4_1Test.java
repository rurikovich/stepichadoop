package cs_algo_theory_and_practice_methods_2.task4;


import org.junit.Test;

import java.util.ArrayList;

import static cs_algo_theory_and_practice_methods_2.task4.CsAlgo2_4_1.TreeItem;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 09.05.2017.
 */
public class CsAlgo2_4_1Test {
    @Test
    public void inOrderTreeSearch() throws Exception {

    }

    @Test
    public void treeSearch() throws Exception {
        ArrayList<TreeItem> tree1 = new ArrayList<>(asList(
                new TreeItem(4, 1, 2),
                new TreeItem(2, 3, 4),
                new TreeItem(5, -1, -1),
                new TreeItem(1, -1, -1),
                new TreeItem(3, -1, -1)
        ));
        assertEquals(asList(1, 2, 3, 4, 5), CsAlgo2_4_1.inOrderTreeSearch(tree1, 0));
        assertEquals(asList(4, 2, 1, 3, 5), CsAlgo2_4_1.preOrderTreeSearch(tree1, 0));
        assertEquals(asList(1, 3, 2, 5, 4), CsAlgo2_4_1.postOrderTreeSearch(tree1, 0));

        ArrayList<TreeItem> tree2 = new ArrayList<>(asList(
                new TreeItem(0, 7, 2),
                new TreeItem(10, -1, -1),
                new TreeItem(20, -1, 6),
                new TreeItem(30, 8, 9),
                new TreeItem(40, 3, -1),
                new TreeItem(50, -1, -1),
                new TreeItem(60, 1, -1),
                new TreeItem(70, 5, 4),
                new TreeItem(80, -1, -1),
                new TreeItem(90, -1, -1)
        ));
        assertEquals(asList(50, 70, 80, 30, 90, 40, 0, 20, 10, 60), CsAlgo2_4_1.inOrderTreeSearch(tree2, 0));
        assertEquals(asList(0, 70, 50, 40, 30, 80, 90, 20, 60, 10), CsAlgo2_4_1.preOrderTreeSearch(tree2, 0));
        assertEquals(asList(50, 80, 90, 30, 40, 70, 10, 60, 20, 0), CsAlgo2_4_1.postOrderTreeSearch(tree2, 0));
    }


}