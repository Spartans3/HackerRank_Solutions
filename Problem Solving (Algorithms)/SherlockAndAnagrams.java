import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

//	https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int count = 0;
    	for(int i = 1 ; i< s.length()  ; i++) {
    		for(int a = 0 ; a< s.length()-i ; a++) {
    			for(int x = a+1; x< s.length()-i+1; x++) {
	    			if(isAnagram(s.substring(a, a+i), s.substring(x, x+i)))
	    				count++;
    			}
    		}
    	}

    	
    	return count;
    }
    
    static boolean isAnagram(String s1, String s2) {
    	char[] c1 = s1.toCharArray();
    	char[] c2 = s2.toCharArray();
    	Arrays.sort(c1);
    	Arrays.sort(c2);
    	for(int i = 0 ; i< c1.length; i++) {
    		if(c1[i] != c2[i])
    			return false;
    	}
    	return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
