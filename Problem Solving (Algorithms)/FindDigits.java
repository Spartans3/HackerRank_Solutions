import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FindDigits {
//	https://www.hackerrank.com/challenges/find-digits/problem
    // Complete the findDigits function below.
    static int findDigits(int n) {
        String numS = String.valueOf(n);
        int counter = 0;
        for(int i=0; i<numS.length();i++) {
            if(Integer.parseInt(String.valueOf(numS.charAt(i))) != 0 &&
                    n % Integer.parseInt(String.valueOf(numS.charAt(i))) == 0)
                counter++;
        }
        
        return counter;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
