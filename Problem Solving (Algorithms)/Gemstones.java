import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Gemstones {
//	https://www.hackerrank.com/challenges/gem-stones/problem
    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        Arrays.sort(arr);
        char[] c = arr[0].toCharArray();
        int gemStones = 0;
        Arrays.sort(c);
        int i = 0;
        boolean add = true;
        while(i<c.length) {
            if(i<c.length-1 && c[i] == c[i+1]) {
                i++;
                continue;
            }
            add = true;
            for(int a = 1; a<arr.length;a++) {
                if(arr[a].indexOf(c[i])<0) {
                    add = false;
                    break;
                }
            }
            if(add)
                gemStones++;
            i++;
        }
        
        return gemStones;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
