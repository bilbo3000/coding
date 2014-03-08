public class Solution {
    public int jump(int[] A) {
        int len = A.length;
        int[] T = new int[len];
        T[0] = 0;
        
        // Initialization 
        for (int i = 1; i <= Math.min(A[0], len - 1); i++) {
            T[i] = 1; 
        }

        for (int i = A[0] + 1; i < len; i++) {
            int j = i - 1;
            int min = Integer.MAX_VALUE;

            while (j >= 0) {
                if (A[j] >= (i - j)) {
                    min = Math.min(min, T[j]);
                }

                T[i] = min + 1;
                j--;
            }
        }

        return T[len - 1];
    }
}
