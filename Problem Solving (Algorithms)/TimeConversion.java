import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
	
	//https://www.hackerrank.com/challenges/time-conversion/problem
    static String timeConversion(String s) {
       SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ssa");
            SimpleDateFormat sdfnormal = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            try{
                cal.setTime(sdf.parse(s)); 
            }catch(Exception e){
                e.printStackTrace();
            }
            
        

        return sdfnormal.format(cal.getTime());



    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
