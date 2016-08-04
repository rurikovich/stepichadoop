package hadoop.task4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_2__9 {
    public static final String INIT_VALUE = "";
    public static final String QUERY = "query";
    public static final String URL = "url";
    public static final String TAB = "\t";
    public static final String DELIMETER = ":";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;
        String prevKey = INIT_VALUE;

        List<String> urls = new ArrayList<>();
        List<String> queries = new ArrayList<>();

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] items = line.split(TAB + "|" + DELIMETER);
            String key = items[0];
            String tag = items[1];
            String value = items[2];

            if (!isFirst(key) && !isPrev(prevKey, key)) {
                for (String q : queries) {
                    for (String u : urls) {
                        System.out.println(prevKey + TAB + q + TAB + u);
                    }
                }
                queries.clear();
                urls.clear();
            }

            if (tag.equals(URL)) {
                urls.add(value);
            }
            if (tag.equals(QUERY)) {
                queries.add(value);
            }
            prevKey = key;

        }

        for (String q : queries) {
            for (String u : urls) {
                System.out.println(prevKey + TAB + q + TAB + u);
            }
        }

    }

    private static boolean isPrev(String prevValue, String value) {
        return prevValue.equals(value);
    }

    private static boolean isFirst(String prevValue) {
        return prevValue.equals(INIT_VALUE);
    }

}
