import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class OrganizingContainersOfBalls {
//	https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        Long[] ballCounts = new Long[container.length];
        Long[] contCounts = new Long[container.length];
        Long sum = 0L;
        Long contSum = 0L;
        int start = 0;
        
        while(start<container[0].length) {
            sum = 0L;
            for (int[] i : container) {
                sum+=i[start];
            }
            ballCounts[start] = sum;
            start++;
        }
        
        for (int i = 0 ; i<container.length ; i++) {
            contSum = 0L;
            for(int a = 0 ; a<container[i].length ; a++) {
                contSum+=container[i][a];
            }
            contCounts[i]= contSum;
            
        }
        
        Arrays.sort(contCounts);
        Arrays.sort(ballCounts);
        for(int x = 0 ; x<contCounts.length ; x++) {
            if(contCounts[x]<ballCounts[x])
                return "Impossible";
        }
        
        return "Possible";
    


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
