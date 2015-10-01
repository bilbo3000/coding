class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     * 
     * DFS approach. http://www.jiuzhang.com/solutions/permutations-ii/
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        int[] visited = new int[nums.size()]; 
        Collections.sort(nums);
        helper(nums, visited, new ArrayList<Integer>(), result);
        
        return result; 
    }
    
    private void helper(ArrayList<Integer> nums, int[] visited, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result) {
        
        if (item.size() == nums.size()) {
            result.add(new ArrayList<Integer>(item));
            return; 
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] == 0) {
                // The check here is the key to avoid duplicates. 
                // The core idea is that when num[i] == num[i - 1]. If i - 1 is 
                // not visited, then going down from i would have one duplicate 
                // the same as when first time going down from i - 1. Think about it!
                if (i > 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == 0) {
                    continue; 
                }
                visited[i] = 1; 
                item.add(nums.get(i));
                helper(nums, visited, item, result);
                item.remove(item.size() - 1);
                visited[i] = 0; 
            }
        }
    }
}

