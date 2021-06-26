package JavaAlgorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ManasaAndStones {

    /*
     * Complete the 'stones' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER a
     *  3. INTEGER b
     */

    public static List<Integer> stones(int n, int a, int b) {
    // Write your code here
    
    //Logic: Run a for loop to multiply the difference numbers to all possible number of     times they can appear between starting and final stone and then add the result of        multiplications to reach the final number. We will use a Set initially to make sure      all duplications are removed. We then convert the Set to List and return it after        sorting  
    
    Set<Integer> setStone=new HashSet<Integer>();
    Integer num=n-1;
    //multiply difference numbers to all the times they can come between starting and          final stone. Add the result of each multiplication which would give the last             stone number in each iteration. Add this final number to the Set.   
    for(Integer i=0,j=num;i<n;i++,j--)
    {
        setStone.add((a*i)+(b*j));
    }
    //convert set to List
    List<Integer> answer=new ArrayList<Integer>(setStone);
    //sort list
    Collections.sort(answer);
    return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\\\Users\\\\Jay\\\\Desktop\\\\Selenium,Drivers and Cucumber\\\\test.txt"));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int a = Integer.parseInt(bufferedReader.readLine().trim());

                int b = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = ManasaAndStones.stones(n, a, b);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
