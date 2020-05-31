import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CounterGame {
//	https://www.hackerrank.com/challenges/counter-game/problem
    // Complete the counterGame function below.
    static String counterGame(long n) {
        
        if(n == 1L)
            return "Richard";
        
        boolean ric = false;
        
        while(n != 1L) {
            if(n%2L !=0) {
                n -= calculateNearest(n);
                ric = !ric;
            }else {
                n /= 2;
                ric = !ric;
            }
                
        }
        
        if(!ric)
            return "Richard";
        else
            return "Louise";
    }

    private static long calculateNearest(long n) {
        int index = 1;
        while(Math.pow(2, index) < n)
            index++;
        return (long) Math.pow(2, index-1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = counterGame(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
