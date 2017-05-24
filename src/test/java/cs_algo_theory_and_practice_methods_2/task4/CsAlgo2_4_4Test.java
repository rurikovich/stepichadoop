package cs_algo_theory_and_practice_methods_2.task4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import static cs_algo_theory_and_practice_methods_2.task4.CsAlgo2_4_4.*;
import static org.junit.Assert.*;

/**
 * @author RastegaevYO
 */
public class CsAlgo2_4_4Test {

    public static final int RANDOM_RANGE = 100;

    @Test
    public void randomTestTree() {
        SearchTree tree = new SearchTree();

        List<Integer> keys = new ArrayList<>();
        List<Integer> deletedKeys = new ArrayList<>();

        addNewTreeItems(tree, keys, 30);
        keys.forEach(key -> assertNotNull(tree.find(key)));


        deleteItemsFormTree(tree, keys, deletedKeys, 10);
        keys.forEach(key -> assertNotNull(tree.find(key)));
        deletedKeys.forEach(key -> assertNull(tree.find(key)));

    }

    private void deleteItemsFormTree(SearchTree tree, List<Integer> keys, List<Integer> deletedKeys, int itemsCountToDelete) {
        Random random = new Random();
        for (int i = 0; i < itemsCountToDelete; i++) {
            Integer keyToDelete = keys.get(random.nextInt(keys.size()));
            deletedKeys.add(keyToDelete);
            keys.remove(keyToDelete);
            System.out.println("- " + keyToDelete);
            tree.delete(keyToDelete);
        }
    }

    private void addNewTreeItems(SearchTree tree, List<Integer> keys, int newItemsCount) {
        Random random = new Random();
        for (int i = 0; i < newItemsCount; i++) {
            int key = Math.abs(random.nextInt(RANDOM_RANGE));
            keys.add(key);
        }

        keys.forEach(key -> {
            System.out.println("+ " + key);
            tree.insert(key);
        });

    }


    private void printTree(SearchTree tree) {
        PriorityQueue<TreeItem> queue = new PriorityQueue<>(tree.items.size());


        System.out.println();

    }

}