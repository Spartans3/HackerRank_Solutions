import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSortPart1 {
//	https://www.hackerrank.com/challenges/insertionsort1/problem
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int temp = 0;
        int a = 0;
        String str = "";
        for(int i = arr.length-1 ; i>0 ; i--) {
            
            if(arr[i]<arr[i-1]) {
                temp = arr[i];
                a = i;

                while(temp<arr[a-1]) {
                    arr[a] = arr[a-1];
                    str = "";
                    for (int x : arr) {
                        str += x + " ";
                    }
                    System.out.println(str);
                    a--;
                    if(a == 0) {
                        arr[a] = temp;
                        break;
                    }
                }
                arr[a] = temp;
            }
        }
        str = "";
        for (int x : arr) {
            str += x + " ";
        }
        System.out.println(str);
        

    


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

        insertionSort1(n, arr);

        scanner.close();
    }
}
