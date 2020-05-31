import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarsExploration {
//	https://www.hackerrank.com/challenges/mars-exploration/problem
    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int sosCount = s.length()/3;
        String sos = "";
        for(int i= 0; i<sosCount ; i++) {
            sos += "SOS";
        }
        int i = 0;
        int errorCount = 0;
        while(i<s.length()) {
            if(s.charAt(i) != sos.charAt(i))
                errorCount++;
            i++;
        }
        return errorCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
