public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length; 
        int curr = len - 1; 
        int last = len - 1;  // index of last valid element 
        
        while (curr >= 0) {
            if (A[curr] == elem) {
                len--; 
                
                if (curr != last) {
                    A[curr] = A[last]; 
                }
                
                curr--; 
                last--; 
            }
            else {
                curr--; 
            }
        }
        
        return len; 
    }
}
