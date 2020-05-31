import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnTheClouds {
//	https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
       if(c.length >2) {
       for (int i = 0; i<c.length-2;i++) {
           if(c[i+1] == 0) {
               if(c[i+2] == 0) {
                   jumps++;
                   i++;
                   continue;
               }
               jumps++;
           }else {
               i++;
               jumps++;
           }
       }
       if( c[c.length-1] == c[c.length-2] && c[c.length-3] !=0)
           jumps++;
       }else if(c.length == 2) {
           if(c[1] == 0)
               jumps = 1;
       }
       return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
