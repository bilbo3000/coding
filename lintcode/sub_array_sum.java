public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     * 
     * O(n^2)
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>(); 
        int i = 0; 
        int j = 0; 
        
        while (i < nums.length) {
            j = i; 
            int sum = 0; 
            
            while (j < nums.length) {
                sum += nums[j]; 
                
                if (sum == 0) {
                    result.add(i);
                    result.add(j);
        
                    return result; 
                } 
                
                j++; 
            }
            
            i++; 
        }
        
        result.add(i);
        result.add(j);
        
        return result; 
    }
}
