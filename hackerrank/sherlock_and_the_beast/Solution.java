import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            boolean found = false; 
            int x = n; 
            
            while (x >= 0) {
                if (x % 3 == 0 && ((n - x) % 5) == 0) {
                    found = true; 
                    break; 
                }
                
                x--; 
            }
            
            if (!found) {
                System.out.println("-1"); 
            } else {
                StringBuilder sb = new StringBuilder(""); 
                
                for (int j = 0; j < x; j++) {
                    sb.append("5"); 
                }
                
                for (int j = 0; j < n - x; j++) {
                    sb.append("3"); 
                }
                
                System.out.println(sb.toString()); 
            }
        }
    }
}
