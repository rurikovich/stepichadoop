

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_1__6 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] keyValue = line.split("\t");
            String url = keyValue[0];
            Integer time = Integer.parseInt(keyValue[1]);
            sumMap.put(url, sumMap.containsKey(url) ? sumMap.get(url) + time : time);
            countMap.put(url, countMap.containsKey(url) ? countMap.get(url) + 1 : 1);
        }
        for (String key : countMap.keySet()) {
            Integer time = sumMap.get(key);
            Integer count = countMap.get(key);

            System.out.println(key + "\t" + time / count);
        }
    }


}
