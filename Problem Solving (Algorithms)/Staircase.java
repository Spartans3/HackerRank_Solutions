import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Staircase {

    // Complete the staircase function below.
	//https://www.hackerrank.com/challenges/staircase/problem
	
    static void staircase(int n) {


    StringBuilder builder = new StringBuilder();
    for (int i = 0; i <n ; i++) 
        builder.append(" ");
    int j = 0;

    for (int i = 1; i <=n; i++) {
        builder.replace(builder.length()-i,          
        builder.length() - j, "#");
        System.out.println(builder);
        j++;
    }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
