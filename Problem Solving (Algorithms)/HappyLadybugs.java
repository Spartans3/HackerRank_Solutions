import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HappyLadybugs {
//	https://www.hackerrank.com/challenges/happy-ladybugs/problem
    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int x = 0;
        map.put('_', 0);
        for(int i = 0; i<b.length(); i++){
            if(map.get(b.charAt(i)) == null)
                map.put(b.charAt(i), 1);
            else {
                x = map.get(b.charAt(i));
                map.put(b.charAt(i), x+1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getKey()!='_' && entry.getValue()==1)
                return "NO";
        }
        if(map.get('_') == 0) {
            for(int i = 1; i<b.length()-1;i++) {
                if(b.charAt(i) != b.charAt(i-1) && b.charAt(i) !=b.charAt(i+1))
                    return "NO";
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
