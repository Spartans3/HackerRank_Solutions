import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CaesarCipher {
//	https://www.hackerrank.com/challenges/caesar-cipher-1/problem
    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        if (k > 26)
            k %= 26;
        for(int i =0; i<s.length();i++) {
            if(s.charAt(i)>=97 &&s.charAt(i)<=122) {
                if(s.charAt(i)+k > 122)
                    sb.setCharAt(i, (char) (96+ s.charAt(i)+k-122));
                else
                    sb.setCharAt(i, (char) (s.charAt(i)+k));
            }else if(s.charAt(i)>=65 &&s.charAt(i)<=90){
                if(s.charAt(i)+k > 90)
                    sb.setCharAt(i, (char) (64+ s.charAt(i)+k-90));
                else
                    sb.setCharAt(i, (char) (s.charAt(i)+k));
            }
        }
        return sb.toString();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
