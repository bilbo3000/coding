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
        int[] arr = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt(); 
        }
        
        int result = findK(arr, 0, arr.length - 1, n / 2 + n % 2); 
        
        System.out.println(result); 
    }
    
    private static int findK(int[] arr, int l, int r, int k) {
        if (l == r) {
            return arr[l]; 
        }
        
        // l < r
        int p = arr[r]; 
        int index = -1;  // Last element that is less than pivot 
        
        for (int i = l; i < r; i++) {
            if (arr[i] < p) {
                index++; 
                int temp = arr[index]; 
                arr[index] = arr[i]; 
                arr[i] = temp; 
            }
        }
        
        index++; 
        int temp = arr[index]; 
        arr[index] = p; 
        arr[r] = temp; 
        
        if (index - l + 1 == k) {
            return arr[index]; 
        }
        
        if (index - l + 1 > k) {
            return findK(arr, l, index - 1, k); 
        } 
        else {
            return findK(arr, index + 1, r, k - (index - l + 1)); 
        }
    }
}
