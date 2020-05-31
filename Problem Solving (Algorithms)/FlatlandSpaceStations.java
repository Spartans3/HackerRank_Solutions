import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FlatlandSpaceStations {
//	https://www.hackerrank.com/challenges/flatland-space-stations/problem
    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        if(c.length == n)
            return 0;
        if(c.length == 1) {
            if(n-c[0] > c[0])
                return n-c[0]-1;
            else
                return c[0];
        }
        Arrays.sort(c);
        int max = 0;
        for (int i = c.length-1; i >0; i--) {
            if(c[i]-c[i-1]>max)
                max=c[i]-c[i-1];
        }
        if(n-c[c.length-1]>max/2) {
            max = n-c[c.length-1]-1;
            if(c[0]-0 > max)
                max = c[0];
        return max;
        }
        if(c[0]-0 > max/2)
            return  c[0];
                    
         return (max/2) ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
