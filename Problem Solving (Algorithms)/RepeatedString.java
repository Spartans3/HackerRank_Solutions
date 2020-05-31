import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {
//	https://www.hackerrank.com/challenges/repeated-string/problem
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        if(s == null || s.trim().equals("")){
            return n;
        }
        Long sLen = new Long(s.length());
        Long modKeyCount = n%s.length();
        Long divideKeyCount = n/s.length();
        Integer firstCharCount = 0;
        Integer modCharCount = 0;
        char a = 'a';
        for(int i= 0; i<s.length(); i++){
            if(s.charAt(i)==a)
                firstCharCount++;
        }
        for(int i= 0; i<modKeyCount.intValue() ; i++){
            if(s.charAt(i)==a)
                modCharCount++;
        }

        return (firstCharCount.longValue() * divideKeyCount) +modCharCount.longValue();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
