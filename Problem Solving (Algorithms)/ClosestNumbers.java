import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClosestNumbers {
//	https://www.hackerrank.com/challenges/closest-numbers/problem
    // Complete the closestNumbers function below.
    static Object[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<Integer>();
        
        int min = Integer.MAX_VALUE;
        for(int i = 2; i<arr.length;i++) {
            if(arr[i]-arr[i-1] < min) {
                list.clear();
                min = arr[i]-arr[i-1];
                list.add(arr[i-1]);
                list.add(arr[i]);
            }else if(arr[i]-arr[i-1] == min) {
                min = arr[i]-arr[i-1];
                list.add(arr[i-1]);
                list.add(arr[i]);
            }
        }
        Object[] a = list.toArray();
        System.out.println(String.valueOf(a[0]));
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        Object[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
