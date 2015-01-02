import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    

    public static void insertIntoSorted(int[] ar) {
        // Fill up this function  
        int size = ar.length; 
        int v = ar[size - 1]; 
        int i = size - 2; 
        
        while (i >= 0 && ar[i] > v) {
            ar[i + 1] = ar[i]; 
            i--; 
            
            for (int j = 0; j < size; j++) {
                System.out.print(ar[j]); 
                System.out.print(" "); 
            }
            System.out.println(); 
        }
        
        ar[i + 1] = v; 
        for (int j = 0; j < size; j++) {
            System.out.print(ar[j]); 
            System.out.print(" "); 
        }
        
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
    
}
