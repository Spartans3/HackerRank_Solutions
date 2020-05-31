import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HackerRankInAString {
//	https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
         String str = "hackerrank";
        int it = 0;
        int count =0;
        if(str.length()>s.length())
            return "NO";
        for(int i = 0; i<str.length();i++) {
            while(it<s.length()) {
                if(str.charAt(i) != s.charAt(it))
                    it++;
                else {
                    it++;
                    count ++;
                    break;
                }
            }
            if(it > s.length() && i<str.length())
                return "NO";
        }
        if(count != str.length())
            return "NO";
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
