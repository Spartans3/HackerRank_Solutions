import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CamelCase {
//	https://www.hackerrank.com/challenges/camelcase/problem
    // Complete the camelcase function below.
    static int camelcase(String s) {
        if(s.length()==0)
            return 0;
        int wordCount = 0;
        Character c = new Character('c');
        for(int i= 0; i<s.length();i++) {
            if(c.isUpperCase(s.charAt(i)))
                wordCount++;
        }
        return wordCount+1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
