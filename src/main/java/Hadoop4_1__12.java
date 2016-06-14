import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_1__12 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;

        HashMap<String, Set<Integer>> gMap = new HashMap<>();

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] keyValue = line.split("\t");
            Integer gNumber = Integer.parseInt(keyValue[0]);
            String g = keyValue[1];
            if (!gMap.containsKey(g)) {
                gMap.put(g, new HashSet<>());
            }
            gMap.get(g).add(gNumber);
        }

        for (String g : gMap.keySet()) {
            System.out.println(g + "\t" + gMap.get(g).size());
        }

    }


}
