public class Solution {
    public int[] searchRange(int[] A, int target) {
        int l = 0; 
        int r = A.length - 1; 
        int [] result = new int[2]; 
        
        while (l <= r) {
            int mid = (l + r) / 2; 
            
            if (A[mid] == target) {
                int i = mid; 
                int j = mid; 
                
                while (i >= 0 && A[i] == target) {
                    i--; 
                }
                
                while (j < A.length && A[j] == target) {
                    j++; 
                }
                
                result[0] = i + 1; 
                result[1] = j - 1; 
                
                return result; 
            }
            else if (A[mid] < target) {
                l = mid + 1; 
            }
            else {
                r = mid - 1; 
            }
        }
        
        result[0] = -1; 
        result[1] = -1; 
        
        return result; 
    }
}
