import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AbsolutePermutation {
//	https://www.hackerrank.com/challenges/absolute-permutation/problem
    // Complete the absolutePermutation function below.
   static int[] absolutePermutation(int n, int k) {
        if(k == 0) {
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = i+1;
            }
            return a;
        }
        
        
        
        
        if(n%2 == 1) {
//            if(n-k <2 || n-k >n/2) {
                int[] a = {-1};
                return a;
//            }else {
//                
//            }
        }else {
            if(n/2 < k || n%(2*k) != 0) {
                int[] a = {-1};
                return a;
            }else {
                int[] a = new int[n];
                for (int i = 0; i < a.length; i++) {
                    a[i] = i+1;
                }
                return swap(a, k);
            }
        }
        
        

    }
    
    static int[] swap(int[] a , int swapJumper) {
        int temp = 0;
        
        int[] swapped = new int[a.length];
        
        for(int i = 0 ; i<a.length ; i++) {
            if(i+swapJumper >=a.length)
                break;
            
            if(swapped[i] == 1)
                continue;
            
            
            temp = a[i] ; 
            a[i] =a[i+swapJumper];
            a[i+swapJumper] = temp;
            
            swapped[i] = 1;
            swapped[i+swapJumper] = 1;
        }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
