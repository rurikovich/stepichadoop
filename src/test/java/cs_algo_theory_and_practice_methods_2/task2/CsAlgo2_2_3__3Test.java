package cs_algo_theory_and_practice_methods_2.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static cs_algo_theory_and_practice_methods_2.task2.CsAlgo2_2_3__3.TableUnion;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 29.04.2017.
 */
public class CsAlgo2_2_3__3Test {

    @Test
    public void unionTables() throws Exception {
        assertEquals(asList(2, 2, 3, 5, 5), CsAlgo2_2_3__3.unionTables(5, 5, asList(1, 1, 1, 1, 1),
                toTableUnionList(new ArrayList<>(asList(
                        3, 5,
                        2, 4,
                        1, 4,
                        5, 4,
                        5, 3
                )))
        ));

        assertEquals(asList(10, 10, 10, 11), CsAlgo2_2_3__3.unionTables(6, 4, asList(10, 0, 5, 0, 3, 3),
                toTableUnionList(new ArrayList<>(asList(
                        6, 6,
                        6, 5,
                        5, 4,
                        4, 3

                )))
        ));
    }

    List<TableUnion> toTableUnionList(ArrayList<Integer> list) {
        List<TableUnion> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 2) {
            res.add(new TableUnion(list.get(i), list.get(i + 1)));
        }
        return res;
    }

}