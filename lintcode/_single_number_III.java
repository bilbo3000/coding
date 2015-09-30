public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     * 
     * O(n)
     */
    public List<Integer> singleNumberIII(int[] A) {
        List<Integer> result = new ArrayList<Integer>(); 
        int res = 0;
        
        for (int i = 0; i < A.length; i++) {
            res = res ^ A[i]; 
        }
        
        // After the loop, res would be the xor of the two 'single' numbers.
        // We need to find the right most 1 becase that is the first bit 
        // two numbers are different. We can use that bit to classify the 
        // inputs into two backets and each bucket will contain one 'single'
        // number. 
        // res & (~(res - 1)) is the right most 1.
        int filter = res & (~(res - 1)); 
        int res1 = 0; 
        int res2 = 0; 
        
        for (int i = 0; i < A.length; i++) {
            if ((filter & A[i]) != 0) {
                res1 = res1 ^ A[i]; 
            } else {
                res2 = res2 ^ A[i]; 
            }
        }
        
        result.add(res1);
        result.add(res2);
        
        return result; 
    }
}
