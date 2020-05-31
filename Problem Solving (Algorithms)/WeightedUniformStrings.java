import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class WeightedUniformStrings {
//	https://www.hackerrank.com/challenges/weighted-uniform-string/problem
    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        HashSet<Integer> set = new HashSet<Integer>();
        int lastValue = s.charAt(0)-96;
        Character lastChar = 'A';
        char[] a = s.toCharArray();
        String[] results = new String[queries.length];
        
        for (int i = 0; i<a.length ; i++) {
            set.add(a[i]-96);
            
            if(lastChar == a[i]) {
                lastValue+=a[i]-96;
                set.add(lastValue);
            }else {
                lastValue = a[i]-96;
            }
            lastChar = a[i];
        }
        
        for (int i= 0; i<queries.length ; i++) {
            if(set.contains(queries[i]))
                results[i] = "Yes";
            else
                results[i] = "No";
        }
        
        return results;
    


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
