import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MigratoryBirds {
//	https://www.hackerrank.com/challenges/migratory-birds/problem
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
   HashMap<Integer,Integer> map = new HashMap<>();
        int val = 0;
        int maxCount = 0;
        int bestNum = 0;
                for (Integer i : arr) {
                    if(map.get(i) == null)
                        map.put(i, 1);
                    else {
                        val = map.get(i);
                        map.put(i, val+1);
                    }
                }
                
                for(int a=1; a<=5;a++) {
                    if(map.get(a)!=null && map.get(a)>maxCount) {
                        maxCount = map.get(a);
                        bestNum = a;
                    }
                }
                return bestNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
