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
        
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt(); 
        }
        
        partition(0, size - 1, arr); 
    }
    
    private static void partition(int l, int r, int[] arr) {
        if (l >= r) {
            return; 
        }
        
        int p = arr[r];  
        int index = l - 1; // Index of last element that is smaller than pivot 
        for (int i = l; i < r; i++) {
            if (arr[i] < p) {
                index++; 
                int temp = arr[index]; 
                arr[index] = arr[i]; 
                arr[i] = temp; 
            }
        }
          
        index++; 
        int temp = arr[r]; 
        arr[r] = arr[index]; 
        arr[index] = temp; 
        
        printArray(arr); 
        
        partition(l, index - 1, arr); 
        partition(index + 1, r, arr); 
    }
    
    static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
}
