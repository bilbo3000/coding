/*
Generate all the permutations of a given array with unique elements. 

Solve it using recursion. 

Each recursion call try every single elements after it at current position. 

Time: O(nxn!)
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>(); 
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
                
        helper(0, list, results);
        return results; 
    }
    
    private void helper(int index, List<Integer> list, List<List<Integer>> results) {
        if (index == list.size() - 1) {
            results.add(new ArrayList<Integer>(list));
            return; 
        }
        
        /* Don't forget try to swap just with its self */
        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, index, i);
            helper(index + 1, list, results);
            // Undo
            Collections.swap(list, index, i);
        }
    }
}
