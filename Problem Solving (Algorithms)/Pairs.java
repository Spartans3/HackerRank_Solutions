import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pairs {
//	https://www.hackerrank.com/challenges/pairs/problem
    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int counter = 0;
        int result = 0;
        for(int i = 0 ; i< arr.length-1 ; i++) {
            for(int a = i+1 ; a<arr.length ;a++) {
                result =Math.abs(arr[i]-arr[a]);
                if(result == k)
                    counter++;
                if(result>k)
                    break;
            }
        }
        return counter;

    
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
