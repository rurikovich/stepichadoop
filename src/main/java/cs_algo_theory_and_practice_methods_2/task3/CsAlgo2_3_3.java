package cs_algo_theory_and_practice_methods_2.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_3_3 {

    static int p = 1_000_000_007;
    static int x = 263;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String pattern = reader.next();
        String text = reader.next();

        List<Integer> results = findPatternIndexes(pattern, text);

        for (int i = results.size() - 1; i >= 0; i--) {
            System.out.print(results.get(i) + (i > 0 ? " " : ""));
        }
    }

    static List<Integer> findPatternIndexes(String pattern, String text) {
        List<Integer> indexes = new ArrayList<>();

        int patternHash = h(pattern, p, x);
        int pLength = pattern.length();
        long x_pow_n_mod_p = x_pow_n_mod_p(1, x, pLength - 1, p);

        int startIndex = text.length() - pLength;
        String lastStr = text.substring(startIndex, text.length());
        long lastSubStrHash = h(lastStr, p, x);

        if (lastSubStrHash == patternHash && lastStr.equals(pattern)) {
            indexes.add(startIndex);
        }

        long prevHash = lastSubStrHash;
        for (int i = startIndex - 1; i >= 0; i--) {
            int lastCharCode = (int) text.charAt(i + pLength);
            int firstCharCode = (int) text.charAt(i);
            long hash = getNextHash(prevHash, x, p, x_pow_n_mod_p, lastCharCode, firstCharCode);

            if (hash == patternHash && text.substring(i, i + pLength).equals(pattern)) {
                indexes.add(i);
            }
            prevHash = hash;
        }
        return indexes;
    }

    static long getNextHash(long prevHash, int x, int p, long x_pow_n_mod_p, int lastCharCode, int firstCharCode) {
        return ((((prevHash - (lastCharCode * x_pow_n_mod_p) % p) + p) % p * x) % p + firstCharCode) % p;
    }


    static int h(String s, int p, int x) {
        long res = 0;

        long x_mod_p = x % p;
        long pow_mod_p = 1;
        for (int i = 0; i < s.length(); i++) {
            int charCode = (int) s.charAt(i);
            res = (res + (charCode * pow_mod_p) % p) % p;
            pow_mod_p = (pow_mod_p * x_mod_p) % p;
        }

        res = res % p;
        return (int) res;
    }

    static long x_pow_n_mod_p(int startValue, int x, int n, int p) {
        long x_mod_p = x % p;
        long pow_mod_p = startValue;
        for (int j = 0; j < n; j++) {
            pow_mod_p = (pow_mod_p * x_mod_p) % p;
        }
        return pow_mod_p;
    }


}
