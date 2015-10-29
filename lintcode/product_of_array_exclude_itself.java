public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     * 
     * O(n)
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        int len = A.size(); 
        long[] left = new long[len]; 
        long[] right = new long[len]; 
        left[0] = 1; 
        right[len - 1] = 1; 
        ArrayList<Long> result = new ArrayList<Long>(); 
        
        for (int i = 1; i < len; i++) {
            left[i] = ((long)A.get(i - 1)) * ((long)left[i - 1]); 
        }
        
        for (int i = len - 2; i >= 0; i--) {
            right[i] = ((long)A.get(i + 1)) * ((long)right[i + 1]); 
        }
        
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                result.add(new Long(right[i]));
            } else if (i == len - 1) {
                result.add(new Long(left[i]));
            } else {
                Long l1 = new Long(left[i]);
                Long l2 = new Long(right[i]);
                result.add(l1 * l2);
            }
        }
        
        return result; 
    }
}

