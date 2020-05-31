import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulDaysAtTheMovies {
//	https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int num1 =0;
        int num2 =0;
        int result = 0;
        int count = 0;
        for(int a=i ; a<=j ; a++){
            num1 = a;
            StringBuilder num = new StringBuilder();
            num.append(a);
            num2 = Integer.parseInt(num.reverse().toString());

            result= Math.abs(num1-num2);

            if(result%k == 0)
                count++;



        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
