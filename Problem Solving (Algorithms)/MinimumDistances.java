import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumDistances {
//	https://www.hackerrank.com/challenges/minimum-distances/problem
    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        List<Integer> list = new ArrayList<>();
        int min = 99999999;
        for (Integer i : a) {
            list.add(i);
        }
        for(int i = 0; i<list.size();i++) {
            if( i != list.lastIndexOf(list.get(i))) {
                if(min> Math.abs(i-list.lastIndexOf(list.get(i))))
                        min = Math.abs(i-list.lastIndexOf(list.get(i)));
            }
        }
        if (min == 99999999)
            return -1;
        return min ;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
