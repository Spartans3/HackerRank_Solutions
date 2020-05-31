import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TheLoveLetterMystery {
//	https://www.hackerrank.com/challenges/the-love-letter-mystery/problem
    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
       int maxOperations = 0;
        char[] charArray = s.toCharArray();
        for(int i = 0; i<charArray.length/2 ; i++) {
            if(charArray[i] > charArray[charArray.length-1-i]) {
                while(charArray[i] != charArray[charArray.length-1-i]) {
                    charArray[charArray.length-1-i] +=1;
                    maxOperations++;
                }
            }else if(charArray[i] < charArray[charArray.length-1-i]) {
                while(charArray[i] != charArray[charArray.length-1-i]) {
                    charArray[i] +=1;
                    maxOperations++;
                }
        }
    }
        return maxOperations;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
