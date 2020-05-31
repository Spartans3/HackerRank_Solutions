import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PalindromeIndex {
//	https://www.hackerrank.com/challenges/palindrome-index/problem
    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        if(isPalindrome(s))
            return -1;
        //aaba
        char[] c = s.toCharArray();
        for(int i = 0; i<s.length()/2 ; i++)
            if(c[i] != c[c.length-1-i]) {
                if(isPalindrome(s.substring(0,i) + s.substring(i+1, s.length())))
                    return i;
                else
                    return c.length-i-1;
            }

        return -1;
    }
    
    static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        for(int i = 0 ; i<c.length/2 ; i++) {
            if(c[i] != c[c.length-1-i])
                return false;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
