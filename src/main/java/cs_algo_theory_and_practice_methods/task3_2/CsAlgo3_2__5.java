package cs_algo_theory_and_practice_methods.task3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo3_2__5 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.next();

        Map<String, Integer> charsFrequencies = getCharsFrequencies(str);

        Map<String, String> encodeMap = getEncodeMap(str);
        String encodedStr = process(str);

        System.out.print(encodeMap.keySet().size());
        System.out.println(encodedStr.length());

        encodeMap.keySet().forEach(k -> System.out.println(k + ":" + encodeMap.get(k)));

        System.out.println(encodedStr);

    }

    public static String process(String str) {
        return "";
    }

    private static Map<String, Integer> getCharsFrequencies(String str) {
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String c = str.substring(i, i + 1);
            if (!res.containsKey(c)) {
                res.put(c, 1);
            } else {
                res.put(c, res.get(c) + 1);
            }
        }
        return res;
    }

    private static Map<String, String> getEncodeMap(String str) {
        return null;
    }

}
