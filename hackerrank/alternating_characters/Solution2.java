import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 { 
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            String line = scanner.next();
            int counter = 0; 
            StringBuilder sb = new StringBuilder(line); 
            int i = 1; 
            
            while (i < sb.length()) {
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    sb.deleteCharAt(i); 
                    i--; 
                    counter++; 
                }
                i++; 
            }
            
            System.out.println(counter);
            t--;
        }
    }
}
