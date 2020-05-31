import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GameOfThronesI {
//	https://www.hackerrank.com/challenges/game-of-thrones/problem
    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        HashMap<Character,Integer> map = new HashMap();
        int counter = 0;
        int oddCount = 0;
        for(int i=0; i<s.length();i++) {
            if(map.get(s.charAt(i)) == null)
                map.put(s.charAt(i), 1);
            else {
                counter = map.get(s.charAt(i));
                map.put(s.charAt(i), counter +1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry :map.entrySet()) {
            if(entry.getValue()%2 == 1)
                oddCount++;
            if(oddCount == 2)
                return "NO";
        }
        if(s.length()%2 == 1 && oddCount == 1)
            return "YES";
        else if(s.length()%2 == 0 && oddCount == 1)
            return "NO";
        else
            return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
