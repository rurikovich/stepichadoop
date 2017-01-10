package javaBaseCourse.task6_2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rurik on 10.01.2017.
 */
public class CollectionManager {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> union = new HashSet<T>();
        union.addAll(set1);
        union.addAll(set2);

        Set<T> intersection = new HashSet<T>();
        for (T s : set1) {
            if (set2.contains(s)) {
                intersection.add(s);
            }
        }

        union.removeAll(intersection);

        return union;
    }

}
