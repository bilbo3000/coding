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
        Map<Integer, Stack<String>> m = new HashMap<Integer, Stack<String>>(); 
        int[] ca = new int[100]; 
        int[] arr = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            int digit = in.nextInt(); 
            String str = in.next(); 
            
            arr[i] = digit; 
            ca[digit]++; 
            
            if (!m.containsKey(digit)) {
                m.put(digit, new Stack<String>()); 
            }
            
            m.get(digit).push(str); 
        }
        
        // Accumulate counting array 
        for (int i = 1; i < ca.length; i++) {
            ca[i] += ca[i - 1]; 
        }
        
        String[] out = new String[n]; 
        
        for (int i = n - 1; i >= 0; i--) {
            int digit = arr[i]; 
            int index = ca[digit] - 1; 
            ca[digit]--; 
            String s = m.get(digit).pop(); 
            
            if (i < n / 2) { // First half 
                out[index] = "-"; 
            } else { // Second half 
                out[index] = s; 
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(out[i]); 
            System.out.print(" "); 
        }
    }
}
