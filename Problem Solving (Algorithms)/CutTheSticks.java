import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CutTheSticks {
//	https://www.hackerrank.com/challenges/cut-the-sticks/problem
    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
    int cutCount = 1;
        
        List<Integer> listCuts = new ArrayList();
        Arrays.sort(arr);
        int min = 0;
        while(cutCount!=0) {
            cutCount = 0;
//            min =Arrays.stream(arr).min().getAsInt();
            for (int i = 0; i<arr.length ; i++) {
                if(arr[i]>0) {
                    min = arr[i];
                    break;
                }
            }
            for (int i = 0; i<arr.length ; i++) {
                if(arr[i]>0) {
                    arr[i] = arr[i] -min;
                    cutCount++;
                }
            }
            if(cutCount !=0)
                listCuts.add(cutCount);
        }
        int[] arrayCuts = new int[listCuts.size()];
        for (int i = 0; i< listCuts.size(); i++) {
            arrayCuts[i] = listCuts.get(i);
        }
        
        return arrayCuts;
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

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
