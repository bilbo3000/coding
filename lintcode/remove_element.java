public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     * 
     * Have a pointer that points the last element of the prefix array that 
     * satisfy the condition. Swap it with the last element if it matches the
     * given element. 
     * 
     * O(n)
     */
    public int removeElement(int[] A, int elem) {
        int len = A.length; 
        int i = 0; 
        
        while (i < len) {
            if (A[i] == elem) {
                A[i] = A[len - 1]; 
                i--; 
                len--; 
            }
            i++; 
        }
        
        return len;
    }
}

