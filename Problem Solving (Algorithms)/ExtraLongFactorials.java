import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ExtraLongFactorials {
//	https://www.hackerrank.com/challenges/extra-long-factorials/problem
    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger bi=BigInteger.valueOf(1);
        while(n > 0){
            bi = bi.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(bi);
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
