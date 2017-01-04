package cs_algo_theory_and_practice_methods.test.utils

/**
 * Created by User on 04.11.2016.
 */
class Helper {
    def static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}
