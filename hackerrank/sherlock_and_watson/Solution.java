import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // Number of elements 
        int k = in.nextInt();  // Rotate K times 
        int q = in.nextInt();  // Number of queries 
        
        k = k % n; 
        
        int[] arr = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt(); 
        }
        
        for (int i = 0; i < q; i++) {
            int x = in.nextInt(); 
            
            if (x >= k) {
                System.out.println(arr[x - k]); 
            } else {
                // x + k - n- 1
                System.out.println(arr[x + n - k]); 
            }
        }
    }
}
