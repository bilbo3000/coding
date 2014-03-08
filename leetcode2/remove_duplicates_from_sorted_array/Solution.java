public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length; 
        int curr = 0; 
        
        while (curr < len - 1) {
            if (A[curr] == A[curr + 1]) {
                int index = curr; 
                
                while (index < len - 1) {
                    A[index] = A[index + 1]; 
                    index++; 
                }
                
                len--; 
            }
            else {
                curr++; 
            }
        }
        
        return len; 
    }
}
