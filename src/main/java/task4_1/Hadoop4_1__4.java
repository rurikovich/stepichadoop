package task4_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_1__4 {


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;
        while (reader.hasNext()) {
            Map<String, Integer> countMap = new HashMap<>();
            line = reader.nextLine();
            for (String term : line.split(" ")) {
                countMap.put(term, countMap.containsKey(term) ? countMap.get(term) + 1 : 1);
            }
            for (Map.Entry<String, Integer> pair : countMap.entrySet()) {
                System.out.println(pair.getKey() + "\t" + pair.getValue());
            }
        }
    }
}
