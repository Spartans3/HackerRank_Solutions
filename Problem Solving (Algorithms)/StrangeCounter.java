import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrangeCounter {
//	https://www.hackerrank.com/challenges/strange-code/problem
    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        int pow = 0;
        long sum = (long) (3*Math.pow(2, pow));
        while(t>sum) {
            pow++;
            sum += 3*Math.pow(2, pow);
        }
        return sum - t+1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
