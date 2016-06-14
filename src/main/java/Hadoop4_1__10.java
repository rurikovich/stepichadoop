import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by rurik on 14.06.2016.
 */
public class Hadoop4_1__10 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;

        Set<String> alreadyPrinted=new HashSet<>();

        while (reader.hasNext()) {
            line = reader.nextLine();
            String[] keyValue = line.split("\t");

            String fg = keyValue[0];
            if(!alreadyPrinted.contains(fg)){
                alreadyPrinted.add(fg);
                System.out.println(fg);
            }


        }
    }


}
