import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram {
//	https://www.hackerrank.com/challenges/anagram/problem
    // Complete the anagram function below.
    static int anagram(String s) {
        if((s.length() % 2) == 1)
            return -1;
        int count = 0;
        int startIndex = (s.length()/2 ) -1;
        char[] chArray = s.substring(startIndex+1).toCharArray();
        ArrayList<Character> listHalf = new ArrayList<Character>();
        for (Character character : chArray) {
            listHalf.add(character);
        }
        
        for(int i = 0; i<=startIndex; i++) {
            if(listHalf.contains(s.charAt(i))) {
                listHalf.remove(listHalf.indexOf(s.charAt(i)));
            }else {
                count++;
            }
            
        }
        
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
