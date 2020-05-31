import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RedKnightsShortestPath {
//	https://www.hackerrank.com/challenges/red-knights-shortest-path/problem
    // Complete the printShortestPath function below.
    static void printShortestPath(int n, int x1, int y1, int x2, int y2) {
        // Print the distance along with the sequence of moves.
        if(Math.abs(x1-x2) % 2 != 0) {
            System.out.println("Impossible");
            return;
        }
        
        
        int moves = 0;
        List<String> listDistance = new ArrayList<String>();
        
        
        while(x1 != x2 || y1 !=y2) {
            
            if(x1>x2) {
                if(y1>y2) {
                    y1 -=1;
                    x1 -=2;
                    listDistance.add("UL");
                }else {
                    y1 +=1;
                    x1 -=2;
                    listDistance.add("UR");
                }
                
                moves++;
                if(x1 == x2 && y1 == y2) {
                    printResult(listDistance, moves);
                    return;
                }
            }else if(x1<x2) {
                if(y1>y2) {
                    y1 -=1;
                    x1 +=2;
                    listDistance.add("LL");
                }else {
                    y1 +=1;
                    x1 +=2;
                    listDistance.add("LR");
                }
                
                moves++;
                if(x1 == x2 && y1 == y2) {
                    printResult(listDistance, moves);
                    return;
                }
            }else {
                if(Math.abs(y1-y2) %2 == 1) {
                    System.out.println("Impossible");
                    return;
                }
                
                if(y1<y2) {
                    y1 += 2;
                    listDistance.add("R");
                }else if(y1>y2) {
                    y1 -=2;
                    listDistance.add("L");
                }else {
                    printResult(listDistance, moves);
                    return;
                }
                moves++;
                
                if(x1 == x2 && y1 == y2) {
                    printResult(listDistance, moves);
                    return;
                }
                
            }
                        
        }
    }
    
    static void printResult(List<String> list, int moves) {
        String str = "";


        if(list.contains("LR")) {
            Comparator<String> c = new Comparator<String>() {
                
                @Override
                public int compare(String o1, String o2) {
                    if(o1.equals("LR") && o2.equals("LL"))
                        return -1;
                    else if(o1.equals("LL") && o2.equals("LR"))
                        return 1;
                    else if(o1.equals("R") && o2.equals("LR"))
                        return -1;
                    else if(o1.equals("LR") && o2.equals("R"))
                        return 1;
                    else
                        return 0;
                    
                }
            };
            
            Collections.sort(list, c);
        }

        for (String step : list) {
            str += step + " ";
        }
        System.out.println(moves);
        System.out.println(str.trim());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] i_startJ_start = scanner.nextLine().split(" ");

        int i_start = Integer.parseInt(i_startJ_start[0]);

        int j_start = Integer.parseInt(i_startJ_start[1]);

        int i_end = Integer.parseInt(i_startJ_start[2]);

        int j_end = Integer.parseInt(i_startJ_start[3]);

        printShortestPath(n, i_start, j_start, i_end, j_end);

        scanner.close();
    }
}
