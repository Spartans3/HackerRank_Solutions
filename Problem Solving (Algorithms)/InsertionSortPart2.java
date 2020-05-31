import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSortPart2 {
//	https://www.hackerrank.com/challenges/insertionsort2/problem
    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr) {
        if(arr.length<2) {
            System.out.println(arr[0]);
            return;
        }
        int temp = 0;
        String str = "";
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]<arr[i]) {
                temp = arr[i+1];
                for(int a = i ; a>=0 ; a--) {
                    if(arr[a]>temp) {
                        arr[a+1] = arr[a];
                        arr[a] = temp;
                    }
                }
            }
            for (int a : arr) {
                str += a + " ";
            }
            System.out.println(str);
            str = "";
        }

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

        insertionSort2(n, arr);

        scanner.close();
    }
}
