import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulBinaryString {
//	https://www.hackerrank.com/challenges/beautiful-binary-string/problem
    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        int index = 1;
        int count = 0;
        while(index<b.length()-1) {
            if(b.substring(index-1,index+2).equals("010")) {
                count++;
                index+=2;
            }
            index++;
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
