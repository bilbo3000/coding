public class Solution2 {
    
    public int singleNumber(int[] A) {
        int[] arr = new int[32];
        
        for (int i = 0; i < 32; i++) {
            arr[i] = 0; 
        }
        
        for (int i = 0; i < A.length; i++) { 
            for (int j = 0; j < 32; j++) {
                if (((1 << j) & A[i]) != 0) {
                    arr[j]++; 
                }
            }    
        }
        
        int result = 0; 
        
        for (int i = 0; i < 32; i++) {
            if (arr[i] != 0 && arr[i] % 3 != 0) {
                result |= 1 << i; 
            }
        }
        
        return result; 
    }
}
