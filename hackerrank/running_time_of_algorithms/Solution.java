import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int size = in.nextInt(); 
        int[] arr = new int[size]; 
        int cnt = 0; 
        
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt(); 
        }
        
        for (int i = 1; i < size; i++) {
            int v = arr[i]; 
            int j = i - 1; 
            
            while (j >= 0 && arr[j] > v) {
                arr[j + 1] = arr[j]; 
                j--; 
                cnt++; 
            }
            
            arr[j + 1] = v; 
        }
        
        System.out.println(cnt); 
    }
}
