// Counting array version 
public class Solution2 {
    public void sortColors(int[] A) {
        int len = A.length; 
        int[] ca = new int[3]; 
        
        for (int i = 0; i < len; i++) {
            ca[A[i]]++; 
        }
        
        ca[1] += ca[0]; 
        ca[2] += ca[1]; 
        int[] B = A.clone(); 
        
        for (int i = len - 1; i >= 0; i--) {
            int item = B[i]; 
            int index = ca[item] - 1; 
            ca[item]--; 
            A[index] = item; 
        }
    }
}
