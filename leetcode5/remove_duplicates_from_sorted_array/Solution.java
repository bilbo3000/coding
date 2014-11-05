public class Solution {
    public int removeDuplicates(int[] A) {
       int len = A.length; 
       
       if (len <= 1) {
           return len; 
       }
       
       int pos = 0; 
       
       for (int i = 1; i < len; i++) {
           int curr = A[i]; 
           int prev = A[i - 1]; 
           
           if (curr != prev) {
               pos++; 
               A[pos] = A[i]; 
           }
       }
       
       return pos + 1; 
    }
}
