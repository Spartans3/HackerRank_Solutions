import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {

	//https://www.hackerrank.com/challenges/mini-max-sum/problem
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        Long min =new Long(0);
        Long max =new Long(0);
        Integer pass = 0;
       
        List<Long> sumList = new ArrayList();

        while (pass <5){
             Long sum = new Long(0);
            for(int i=0; i<arr.length ;i++){
                if(i!=pass){
                    sum +=arr[i];
                }
            }
            sumList.add(sum);
            min = sum;
            pass++;
        }
        
        for(Long a : sumList){
            if(a>max)
                max = a;
            if(a<min)
                min = a;
        }

        System.out.println(min + " "+ max);


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
