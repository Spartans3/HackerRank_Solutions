import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HackerlandRadioTransmitters {
//	https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        
        for (Integer integer : x) {
            System.out.print(integer + " ");
        }
        
        int start = 0;
        int count = 0;
        int index = 0;
        while(index<x.length) {
            start = x[index]+k;
            //before
            while(index<x.length &&  x[index]<=start) {
                index++;
            }
            index--;
            //mid
            start = x[index] + k;
            while(index<x.length && x[index]<=start) {
                index++;
            }
            count++;
        }

        return count;
    


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
