import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TheFullCountingSort {
//	https://www.hackerrank.com/challenges/countingsort4/problem
    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {
            Map<String,List<String>> map = new HashMap<String, List<String>>();
            int max = 0;
            
            for(int i = 0 ; i<arr.size(); i++) {
//                if(i<arr.size()/2)
//                    arr.get(i).set(1, "-");
                    
                if(Integer.parseInt(arr.get(i).get(0)) > max)
                    max =Integer.parseInt(arr.get(i).get(0));
                    
                if(map.get(arr.get(i).get(0)) == null) {
                    List<String> list = new ArrayList<String>();
                    if(i<arr.size()/2)
                        list.add("-");
                    else
                        list.add(arr.get(i).get(1));
                    map.put(arr.get(i).get(0), list);
                }else {
                    if(i<arr.size()/2)
                        map.get(arr.get(i).get(0)).add("-");
                    else
                        map.get(arr.get(i).get(0)).add(arr.get(i).get(1));
                }
            }
            
            StringBuilder result = new StringBuilder();
            
            
            for(int i = 0 ; i<=max ; i++) {
                
                if(map.get(String.valueOf(i)) == null)
                    continue;
                
                List<String> vals = map.get(String.valueOf(i));
                
                for(int a = 0 ; a<vals.size() ; a++) {
                    result.append(vals.get(a)); 
                    result.append(" ");
                }
                
            }
            
            System.out.println(result);
            

    


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        countSort(arr);

        bufferedReader.close();
    }
}
