import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pangrams {
//	https://www.hackerrank.com/challenges/pangrams/problem
    // Complete the pangrams function below.
    static String pangrams(String s) {
        s = s.toLowerCase();
        List<Character> listChar = new ArrayList<>();
        for(int i = 0; i<s.length() ; i++) {
            if(!listChar.contains(s.charAt(i)) && s.charAt(i) != ' ')
                listChar.add(s.charAt(i));
            if(listChar.size() == 26)
                return "pangram";
        }
        return "not pangram";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
