import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FlippingBits {
//	https://www.hackerrank.com/challenges/flipping-bits/problem
    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        String str = Long.toBinaryString(n);
        StringBuilder s = new StringBuilder("");
        for (int toPrepend=32-str.length(); toPrepend>0; toPrepend--) {
            s.append('0');
        }
        s.append(str);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0')
                s.setCharAt(i, '1');
            else
                s.setCharAt(i, '0');
        }
        return Long.parseLong(s.toString(), 2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
