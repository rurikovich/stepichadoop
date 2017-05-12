package cs_algo_theory_and_practice_methods_2.task4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static cs_algo_theory_and_practice_methods_2.task4.CsAlgo2_4_2_light.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by User on 09.05.2017.
 */
public class CsAlgo2_4_2Test {
    @Test
    public void checkTree() throws Exception {

        assertTrue(CsAlgo2_4_2_light.checkTree(createTree(asList(
                new TreeItem(2, 1, 2),
                new TreeItem(1, -1, -1),
                new TreeItem(3, -1, -1)
        ))));

        assertTrue(CsAlgo2_4_2_light.checkTree(createTree(new ArrayList<>())));

        assertTrue(CsAlgo2_4_2_light.checkTree(createTree(asList(
                new TreeItem(1, -1, 1),
                new TreeItem(2, -1, 2),
                new TreeItem(3, -1, 3),
                new TreeItem(4, -1, 4),
                new TreeItem(5, -1, -1)
        ))));

        assertTrue(CsAlgo2_4_2_light.checkTree(createTree(asList(
                new TreeItem(4, 1, 2),
                new TreeItem(2, 3, 4),
                new TreeItem(6, 5, 6),
                new TreeItem(1, -1, -1),
                new TreeItem(3, -1, -1),
                new TreeItem(5, -1, -1),
                new TreeItem(7, -1, -1)
        ))));


        assertFalse(CsAlgo2_4_2_light.checkTree(createTree(asList(
                new TreeItem(4, 1, -1),
                new TreeItem(2, 2, 3),
                new TreeItem(1, -1, -1),
                new TreeItem(5, -1, -1)
        ))));


        assertFalse(CsAlgo2_4_2_light.checkTree(createTree(asList(
                new TreeItem(1, 1, 2),
                new TreeItem(2, -1, -1),
                new TreeItem(3, -1, -1)
        ))));
    }

    private SearchTree createTree(List items) {
        ArrayList<TreeItem> treeItems = new ArrayList<>(items);
        return new SearchTree(treeItems);
    }

}