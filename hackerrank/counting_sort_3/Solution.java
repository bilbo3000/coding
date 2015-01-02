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
        int[] arr = new int[100];
        
        for (int i = 0; i < n; i++) {
            int digit = in.nextInt(); 
            String str = in.next(); 
            arr[digit]++; 
        }
        
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1]; 
        }
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]); 
            System.out.print(" "); 
        }
    }
}
