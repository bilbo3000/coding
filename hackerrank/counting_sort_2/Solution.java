import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[] arr = new int[100]; 
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt(); 
        
        for (int i = 0; i < n; i++) {
            int digit = in.nextInt(); 
            arr[digit]++; 
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.print(i); 
                System.out.print(" "); 
            }
        }
    }
}
