import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in); 
        int n = scanner.nextInt(); 
        
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt(); 
            int num = d; 
            int cnt = 0; 
            
            while (d > 0) {
                int digit = d % 10; 
                d = d / 10; 
                
                if (digit == 0) {
                    continue; 
                }
                
                if (num % digit == 0) {
                    cnt++; 
                }
            }
            
            System.out.println(cnt); 
        }
    }
}
