class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * 
     * If current element is the same as previous element, only insert current 
     * element to the new subsets introduced by the previous element. 
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        Collections.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        result.add(new ArrayList<Integer>());
        int count = 1; 
        
        for (int i = 0; i < S.size(); i++) {
            int len = 0; 
            
            if (i != 0 && S.get(i) == S.get(i - 1)) {
                len = count; 
            } else {
                len = result.size(); 
            }
            
            count = 0; 
            
            int size = result.size(); 
            
            for (int j = size - 1; j >= size - len; j--) {
                ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
                temp.add(S.get(i));
                result.add(temp);
                count++; 
            }
        }
        
        return result; 
    }
}

