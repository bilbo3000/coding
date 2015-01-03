import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt();
        
        for (int k = 0; k < n; k++) {
            int size = in.nextInt(); 
            int[] arr = new int[size]; 
            int right = 0; 
            
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt(); 
                right += arr[i]; 
            }
            
            boolean found = false; 
            int left = 0; 
            
            for (int i = 0; i < size; i++) {
                right -= arr[i]; 
                if (left == right) {
                    System.out.println("YES");
                    found = true; 
                    break; 
                }
                left = left + arr[i];  
            }
            
            if (!found) {
                System.out.println("NO"); 
            }
        }
    }
}
