public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length; 
        
        for (int i = 0; i < len; i++) {
            if (A[i] > 0 && A[i] - 1 != i && A[i] - 1 < len && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1]; 
                A[A[i] - 1] = A[i]; 
                A[i] = temp; 
                i--; 
            }
        }
        
        int index = 0; 
        
        while (index < len && A[index] == index + 1) {
            index++; 
        }
        
        return index + 1; 
    }
}
