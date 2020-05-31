import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

	//https://www.hackerrank.com/challenges/plus-minus/problem
	
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int plusCount = 0;
        int minusCount = 0;
        int zeroCount = 0;
        for (int i : arr) {
            if(i>0)
                plusCount++;
            else if(i<0)
                minusCount++;
            else
                zeroCount++;
        }
        
        System.out.println(plusCount/(float) arr.length);
        System.out.println(minusCount/(float) arr.length);
        System.out.println(zeroCount/(float) arr.length);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
