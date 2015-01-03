import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt(); 
        
        for (int k = 0; k < n; k++) {
            int size = in.nextInt(); 
            int[] arr = new int[size]; 
            
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt(); 
            }
            
            boolean found = false; 
            
            for (int i = 0; i < size; i++) {
                int left = sum(arr, 0, i - 1); 
                int right = sum(arr, i + 1, size - 1); 
                
                if (left == right) {
                    System.out.println("YES");
                    found = true; 
                    break; 
                }
            }
            
            if (!found) {
                System.out.println("NO"); 
            }
        }
    }
    
    private static int sum (int[] arr, int l, int r) {
        if (l > r) {
            return 0; 
        }
        
        if (l == r) {
            return arr[l]; 
        }
        
        int sum = 0; 
        
        for (int i = l; i <= r; i++) {
            sum += arr[i]; 
        }
        
        return sum; 
    }
}
