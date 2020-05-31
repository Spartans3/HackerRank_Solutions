import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */
	
	//https://www.hackerrank.com/challenges/grading/problem

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
    List<Integer> listThisResultIsBullShit = new ArrayList();
    for(Integer grade : grades){
        if(grade >=38){
           // System.out.println("grade ="+ ((grade%5) == 3));
            if(((grade % 5) == 4)){
                grade++;
                listThisResultIsBullShit.add(grade);
            }
            else if(((grade % 5) == 3)){
                grade = grade +2;
                listThisResultIsBullShit.add(grade);
            }else{
                listThisResultIsBullShit.add(grade);
            }
                
        }else{
             listThisResultIsBullShit.add(grade);
        }
    }
   /* int grade = 0;
    for(int i=0;i<grades.size();i++){
        grade =grades.get(i);
         if(grade >=38){
            if((grade % 5) == 4){
                grade++;
                grades.get(i)=grade;
            }
                
            else if((grade % 5) == 3){
                grade = grade +2;
                grades.get(i) = grade;
            }
        }
    }*/



        return listThisResultIsBullShit;
    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < gradesCount; i++) {
            int gradesItem = Integer.parseInt(bufferedReader.readLine().trim());
            grades.add(gradesItem);
        }

        List<Integer> result = Result.gradingStudents(grades);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
