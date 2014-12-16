// Make sure to use long instead of int. 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        long lines = in.nextLong(); 
        
        for (long i = 0; i < lines; i++) {
            long n = in.nextLong(); 
            
            if (n == 0 || n == 1) {
                System.out.println("IsFibo"); 
                continue; 
            }
            
            long curr = 1; 
            long prev = 1; 
            
            while (curr < n) {
                long next = prev + curr; 
                prev = curr; 
                curr = next; 
            }
            
            if (curr == n) {
                System.out.println("IsFibo"); 
            } else {
                System.out.println("IsNotFibo"); 
            }
        }
    }
}
