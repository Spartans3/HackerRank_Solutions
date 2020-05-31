import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CavityMap {
//	https://www.hackerrank.com/challenges/cavity-map/problem
    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        if(grid.length <= 2)
            return grid;
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 1; i < grid.length-1; i++) {
            list.add(new ArrayList<>());
            for(int k = 1 ; k<grid[i].length()-1;k++) {
                if(Integer.parseInt(grid[i].substring(k, k+1)) > Integer.parseInt(grid[i-1].substring(k, k+1))
                    && Integer.parseInt(grid[i].substring(k, k+1)) > Integer.parseInt(grid[i+1].substring(k, k+1))
                    && Integer.parseInt(grid[i].substring(k, k+1)) > Integer.parseInt(grid[i].substring(k+1, k+2))
                    && Integer.parseInt(grid[i].substring(k, k+1)) > Integer.parseInt(grid[i].substring(k-1, k))) {
                list.get(i-1).add(k);
                }
            }
        }
        
        for (int i = 0; i<list.size();i++) {
            StringBuilder str = new StringBuilder(grid[i+1]);
            for (Integer num : list.get(i)) {
                str.setCharAt(num, 'X');
            }
            grid[i+1] =str.toString();
        }
        
        return grid;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
