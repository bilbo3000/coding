
import java.util.*;
public class Solution {
       
       static void partition(int[] ar) {
            int size = ar.length; 
            int p = ar[0]; 
           ArrayList<Integer> lower = new ArrayList<Integer>(); 
           ArrayList<Integer> upper = new ArrayList<Integer>(); 
           
           for (int i = 1; i < size; i++) {
               if (ar[i] <= p) {
                   lower.add(ar[i]); 
               } else {
                   upper.add(ar[i]); 
               }
           }
           
           int i = 0;
           
           for (int item : lower) {
               ar[i] = item; 
               i++; 
           }
           
           ar[i] = p; 
           i++; 
           
           for (int item : upper) {
               ar[i] = item; 
               i++; 
           }
           
           printArray(ar); 
       }   
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           partition(ar);
       }    
   }
