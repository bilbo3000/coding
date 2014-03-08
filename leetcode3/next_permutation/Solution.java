public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length; 
        int i = len - 2; 
        
        while (i >= 0) {
            if (num[i] < num[i + 1]) break; 
            
            i--; 
        }
        
        if (i < 0) {
            Arrays.sort(num); 
        }
        else {
            int j = len - 1; 
            
            while (j > i && num[j] <= num[i]) {
                j--; 
            }
            
            int temp = num[i]; 
            num[i] = num[j]; 
            num[j] = temp; 
            Arrays.sort(num, i + 1, len); 
        }
    }
}
