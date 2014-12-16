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
            int cycles = in.nextInt(); 
            long height = 1; 
            boolean isDouble = true; 
            
            while (cycles > 0) {
                if (isDouble) {
                    isDouble = false; 
                    height *= 2; 
                } else {
                    isDouble = true; 
                    height += 1; 
                }
                
                cycles--; 
            }
            
            System.out.println(height); 
        }
    }
}
