package hadoop.task4_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_1__15 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] items = line.split(" ");
            for (String a : items) {
                Map<String, Integer> stripe = new HashMap<>();
                for (String b : items) {
                    if (!a.equals(b)) {
                        if (!stripe.containsKey(b)) {
                            stripe.put(b, 1);
                        } else {
                            stripe.put(b, stripe.get(b) + 1);
                        }
                    }
                }
                String output = getOutput(a, stripe);
                System.out.println(output);
            }
        }


    }

    private static String getOutput(String a, Map<String, Integer> stripe) {
        String output = a + "\t";
        for (String s : stripe.keySet()) {
            output += s + ":" + stripe.get(s) + ",";
        }
        output = output.substring(0, output.length() - 1);
        return output;
    }
}
