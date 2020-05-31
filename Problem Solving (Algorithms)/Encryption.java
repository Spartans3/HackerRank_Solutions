import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption {
//	https://www.hackerrank.com/challenges/encryption/problem
    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replace(" ", "");
        int colums = (int) Math.ceil(Math.sqrt(s.length()));
        List<String> list = new ArrayList<String>();
        for(int i = 0; i<s.length() ; i+=colums) {
            if(i+colums <s.length())
                list.add(s.substring(i, i+colums));
            else {
                list.add(s.substring(i,s.length()));
            }
        }
        String encrypted = "";
        int start = 0;
        while(start<colums) {
            for (String string : list) {
                if(string.length()>start) {
                    encrypted += string.charAt(start);
                }
            }
            encrypted+= " ";
            start++;
        }
        return encrypted;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
