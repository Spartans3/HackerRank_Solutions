import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */


//https://www.hackerrank.com/challenges/taum-and-bday/problem


public class TaumAndBday {
	
    public static BigInteger taumBday(int b, int w, int bc, int wc, int z) {
    // Write your code here
        BigInteger bigB= new BigInteger(String.valueOf(b));
        BigInteger bigW= new BigInteger(String.valueOf(w));
        BigInteger bigBc= new BigInteger(String.valueOf(bc));
        BigInteger bigWc= new BigInteger(String.valueOf(wc));
        if(Math.abs(bc-wc) - z >0 ) {
            if(bc>wc) 
                bigBc = bigWc.add(new BigInteger(String.valueOf(z)));
            else
                bigWc = bigBc.add(new BigInteger(String.valueOf(z)));
        }
        
        return bigB.multiply(bigBc).add(bigW.multiply(bigWc));
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int b = Integer.parseInt(firstMultipleInput[0]);

            int w = Integer.parseInt(firstMultipleInput[1]);

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int bc = Integer.parseInt(secondMultipleInput[0]);

            int wc = Integer.parseInt(secondMultipleInput[1]);

            int z = Integer.parseInt(secondMultipleInput[2]);

            BigInteger result = taumBday(b, w, bc, wc, z);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
