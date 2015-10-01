class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     * 
     * O(n*n!)
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        if (nums == null) {
            return result; 
        }
        
        result.add(new ArrayList<Integer>());
        int len = nums.size(); 
        int i = len - 1; 
        
        while (i >= 0) {
            int n = nums.get(i); 
            int j = result.size() - 1; 
            
            while (j >= 0) {
                ArrayList<Integer> item = result.get(j); 
                
                for (int k = 0; k < item.size(); k++) {
                    ArrayList<Integer> copy = new ArrayList<Integer>(item);
                    copy.add(k, n);
                    result.add(copy);
                }
                
                item.add(n);
                
                j--; 
            }
            
            i--; 
        }
        
        return result; 
    }
}

