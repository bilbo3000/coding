class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * 
     * Recursive solution. 
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        result.add(new ArrayList<Integer>());
        
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = result.size() - 1; j >= 0; j--) {
                ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
                temp.add(0, nums[i]);
                result.add(temp);
            }
        }
        
        return result; 
    }
}
