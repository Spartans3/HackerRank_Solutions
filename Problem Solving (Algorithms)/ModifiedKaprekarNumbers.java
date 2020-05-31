import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ModifiedKaprekarNumbers {
//	https://www.hackerrank.com/challenges/kaprekar-numbers/problem
    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        String resultText = "";
        for(int i = p ; i<=q ; i++) {
            String result = String.valueOf((long) Math.pow(i, 2));
            String l = result.substring(0, result.length()/2);
            String r = result.substring(result.length()/2);
            if(r.equals(""))
                r = "0";
            if(l.equals(""))
                l = "0";
            if(Integer.valueOf(l) + Integer.valueOf(r) == i)
                resultText += i + " "; 
        }
        if(resultText.equals(""))
            System.out.println("INVALID RANGE");
        else
            System.out.println(resultText);

     }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
