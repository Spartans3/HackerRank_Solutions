import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndTheBeast {
//	https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
    // Complete the decentNumber function below.
    static void decentNumber(int n) {
        int a3 = 0;
        int a5 = 0;
        while(5*a3 + 3*a5 <n) {
            if((n-(a3*5))%3 == 0)
                a5 = (n-(a3*5))/3;
            else
                a3++;
        }
        if(5*a3 + 3*a5 ==n) {
        StringBuilder sb = new StringBuilder("");
        for (int i= 0;  i< a5*3; i++) {
            sb.append("5");
        }
        for (int i= 0;  i< a3*5; i++) {
            sb.append("3");
        }
        System.out.println(sb.toString());
        }else
            System.out.println("-1");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            decentNumber(n);
        }

        bufferedReader.close();
    }
}
