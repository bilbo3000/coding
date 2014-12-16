import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        long n = in.nextLong();  // Number of jars 
        long m = in.nextLong();  // Number of operations 
        long sum = 0; 
        
        for (long i = 0; i < m; i++) {
            long a = in.nextLong(); 
            long b = in.nextLong(); 
            long k = in.nextLong(); 
            
            sum += (b - a + 1) * k; 
        }
        
        long result = sum / n; 
        System.out.println(result); 
    }
}
