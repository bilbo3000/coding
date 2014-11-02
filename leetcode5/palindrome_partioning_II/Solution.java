public class Solution {
    public int minCut(String s) {
        int len = s.length(); 
        
        if (len == 0 || len == 1) {
            return 0; 
        }
        
        boolean[][] T = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            T[i][i] = true; 
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                T[i][i + 1] = true; 
            }
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && T[i + 1][j - 1]) {
                    T[i][j] = true; 
                }
            }
        }
        
        int[] arr = new int[len]; 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i; 
        } 
        
        for (int i = 1; i < arr.length; i++) {
            if (T[0][i]) {
                arr[i] = 0; 
                continue; 
            }
            
            int j = i - 1; 
            
            while (j >= 0) {
                if (T[j + 1][i]) {
                    arr[i] = Math.min(arr[i], arr[j] + 1); 
                }
                
                j--; 
            }
        }
        
        return arr[arr.length - 1]; 
    }
}
