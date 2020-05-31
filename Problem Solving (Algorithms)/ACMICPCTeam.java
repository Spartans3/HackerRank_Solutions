import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ACMICPCTeam {
//	https://www.hackerrank.com/challenges/acm-icpc-team/problem
    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int[] result = new int[2];
        int max = 0;
        int localCount = 0;
        int maxCount = 0;
        for(int i = 0; i < topic.length-1 ; i++) {
            char[] arr1 = topic[i].toCharArray();
            for(int a = i+1 ; a< topic.length ; a++) {
                char[] arr2 = topic[a].toCharArray();
                localCount = 0;
                for (int x = 0 ; x<arr2.length ; x++) {
                    if((arr1[x] | arr2[x]) == '1') 
                        localCount ++;
                }
                if(localCount > max) {
                    max = localCount;
                    maxCount = 1;
                }else if( localCount == max)
                    maxCount++;
                
            }
        }
        
        result[0] = max;
        result[1] = maxCount;
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

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
