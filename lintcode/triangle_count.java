public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     * 
     * O(n^3)
     */
    public int triangleCount(int S[]) {
        int count = 0; 
        int len = S.length; 
        
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (isTriangle(S[i], S[j], S[k])) {
                        count++; 
                    }
                }
            }
        }
        
        return count; 
    }
    
    private boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (b + c > a) && (a + c > b); 
    }
}

