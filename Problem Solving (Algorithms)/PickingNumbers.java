import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
//	https://www.hackerrank.com/challenges/picking-numbers/problem




public class PickingNumbers {
    public static int pickingNumbers(List<Integer> a) {
    // Write your code here
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int temp = 0;
        for(int i = 0; i<a.size();i++) {
            if(map.get(a.get(i)) ==null) {
                map.put(a.get(i), 1);
            }else {
                temp = map.get(a.get(i));
                map.put(a.get(i), temp+1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(map.get(entry.getKey()-1) !=null) {
                if(entry.getValue() + map.get(entry.getKey()-1) >max)
                    max = entry.getValue() + map.get(entry.getKey()-1);
            }
            if(map.get(entry.getKey()+1) !=null) {
                if(entry.getValue() + map.get(entry.getKey()+1) >max)
                    max = entry.getValue() + map.get(entry.getKey()+1);
            }
            if(entry.getValue()>max)
                max = entry.getValue();
        }
        if(map.entrySet().size() == 1)
            return a.size();
        
        return max;
    }
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
