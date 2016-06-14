

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_1__7 {

        public static void main(String[] args) {
            Scanner reader = new Scanner(System.in);
            String line;

            String url = "";
            Integer time = 0;
            int sum = 0;
            int count = 0;

            String prevUrl = "";

            while (reader.hasNext()) {
                line = reader.nextLine();
                String[] keyValue = line.split("\t|;");
                url = keyValue[0];
                time = Integer.parseInt(keyValue[1]);

                if (prevUrl.equals("") || url.equals(prevUrl)) {
                    sum += time;
                    count++;
                } else {
                    System.out.println(prevUrl + "\t" + sum+";"+count);
                    sum = time;
                    count = 1;
                }
                prevUrl=url;
            }
            System.out.println(prevUrl + "\t" + sum+";"+count);
        }


}
