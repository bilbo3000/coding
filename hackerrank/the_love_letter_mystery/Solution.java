import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        int lines = in.nextInt(); 
        
        for (int i = 0; i < lines; i++) {
            String s = in.next();
            int len = s.length(); 
            int l = 0; 
            int r = len - 1; 
            int result = 0; 
            
            while (l < r) {
                int diff = Math.abs(s.charAt(l) - s.charAt(r)); 
                result += diff; 
                l++; 
                r--; 
            }
            
            System.out.println(result); 
        }
    }
}
