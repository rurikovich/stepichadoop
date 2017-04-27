package cs_algo_theory_and_practice_methods_2.task2;

import org.junit.Before;
import org.junit.Test;

import static cs_algo_theory_and_practice_methods_2.task2.MinHeap.*;
import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by User on 26.04.2017.
 */
public class MinHeapTest {

    MinHeap minHeap;

    @Before
    public void setUp() throws Exception {
        minHeap = new MinHeap();
    }

    @Test
    public void insertGetMinTest() throws Exception {
        minHeap.insert(10);
        assertEquals(asList(10), asList(minHeap.getArr()));

        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(9);
        assertEquals(asList(1,2,5,10,9), asList(minHeap.getArr()));

        int min = minHeap.getMin();
        assertEquals(1,min);
        assertEquals(asList(2,9,5,10),asList(minHeap.getArr()));
    }

    @Test
    public void buildHeap() throws Exception {
        assertEquals(asList(1, 2, 2, 3, 7, 4), asList(minHeap.buildHeap(new Integer[]{2, 1, 4, 3, 7, 2})));


        minHeap.buildHeap(new Integer[]{0, 1, 2, 3, 4, 5});
        assertEquals(asList(), minHeap.swaps);

        minHeap.buildHeap(new Integer[]{7, 6, 5, 4, 3, 2});
        assertEquals(asList(new Swap[]{new Swap(2, 5), new Swap(1, 4), new Swap(0, 2), new Swap(2, 5)}), minHeap.swaps);

        minHeap.buildHeap(new Integer[]{5, 4, 3, 2, 1});
        assertEquals(asList(new Swap[]{new Swap(1, 4), new Swap(0, 1), new Swap(1, 3)}), minHeap.swaps);
    }

    @Test
    public void pushDown() throws Exception {


        Integer[] arr = {2, 1, 4};
        minHeap.setSize(arr.length);
        minHeap.pushDown(arr, 0);
        assertEquals(asList(1, 2, 4), asList(arr));


        Integer[] arr2 = {2, 1, 4, 3, 7, 2};
        minHeap.setSize(arr2.length);
        minHeap.pushDown(arr2, 0);
        assertEquals(asList(1, 2, 4, 3, 7, 2), asList(arr2));
    }

}