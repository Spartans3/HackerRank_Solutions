import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RunningTimeOfAlgorithms {
//	https://www.hackerrank.com/challenges/runningtime/problem
    // Complete the runningTime function below.
    static int runningTime(int[] arr) {
        int x = 0;
        int temp = 0;
        int shifts = 0;
        while(x<arr.length) {
            for(int i= x; i<arr.length ; i++) {
                if(arr[x]> arr[i]) {
                    if(i>x+1) {
                        temp = arr[i];
                        arr[i] = arr[i-1];
                        arr[i-1] = temp;
                        i=x;
                    }else {
                        temp = arr[i];
                        arr[i] = arr[x];
                        arr[x] = temp;
                    }
                    shifts++;
                }
            }
            x++;
        }
        return shifts;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
