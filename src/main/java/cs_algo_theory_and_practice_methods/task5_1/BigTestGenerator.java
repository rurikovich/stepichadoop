package cs_algo_theory_and_practice_methods.task5_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by rurik on 24.08.2016.
 */
public class BigTestGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        generate();
    }

    private static void generate() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File("input.txt"));
        int n = 100000;
        int k = 100000;
        Random random = new Random();
        int[] a = new int[n];
        int[] b = new int[k];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(1000000000);
        }
        Arrays.sort(a);

        for (int i = 0; i < n; i++) {
            b[i] = a[random.nextInt(n)];
        }
        printWriter.print(n);
        for (int i = 0; i < n; i++) {
            printWriter.print(" " + a[i]);
        }
        printWriter.println();


        printWriter.print(k);
        for (int i = 0; i < k; i++) {
            printWriter.print(" " + b[i]);
        }
        printWriter.println();

        printWriter.close();

    }
}
