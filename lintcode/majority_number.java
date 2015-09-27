public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     * 
     * There is at most one element that could appear more than half of the time.
     * The idea was that a same element will accumulate the current result and 
     * a different one will cancel the current result. Thus, the majority element
     * will eventually grab the seat. The worse case is that all other elements will 
     * cancel against majority element, but there will still be at least one 
     * majority element left in the end. 
     * O(n)
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size(); 
        int result = 0;
        int cnt = 0; 
        
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            
            if (cnt == 0) {
                result = n;
                cnt++; 
            } else if (n == result) {
                cnt++; 
            } else {
                cnt--; 
            }
        }
        
        return result; 
    }
}

