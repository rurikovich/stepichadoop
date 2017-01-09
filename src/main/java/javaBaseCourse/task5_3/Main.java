package javaBaseCourse.task5_3;

import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by rurik on 09.01.2017.
 */
public class Main {
    public static void main(String[] args) {
//        Reader reader = new StringReader("1 2 3");
//        Reader reader = new StringReader("a1 b2 c3");
//        Scanner in = new Scanner(reader);
        Scanner in = new Scanner(System.in);
        Double sum = 0d;

        while (in.hasNext()) {
            String s = in.next();
            try {
                sum += Double.parseDouble(s);
            } catch (NumberFormatException e) {
            }
        }
        NumberFormat formatter = new DecimalFormat("#0.000000");
        String formatedValue = formatter.format(sum);
        System.out.print(formatedValue);
    }
}
