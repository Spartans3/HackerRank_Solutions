import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SherlockAndArray {
//	https://www.hackerrank.com/challenges/sherlock-and-array/problem
    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        if(arr.size() == 1)
            return "YES";
        
        Integer right = 0;
        Integer left = 0;
        int mid = arr.get(0);
        for(int i = 1 ; i<arr.size() ; i++) {
            right += arr.get(i);
        }
        
        for(int i = 1 ; i<arr.size() ; i++) {
            if(right.equals(left))
                return "YES";
            else if(left > right)
                return "NO";
            else {
                right -=arr.get(i);
                left+= mid;
                mid = arr.get(i);
            }
        }
        
        return "NO";
        

    


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
