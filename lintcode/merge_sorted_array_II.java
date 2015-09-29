class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     * O(n + m)
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>(); 
        int i = 0; 
        int j = 0; 
        
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                result.add(A.get(i));
                i++; 
            } else {
                result.add(B.get(j));
                j++; 
            }
        }
        
        while (i < A.size()) {
            result.add(A.get(i));
            i++; 
        }
        
        while (j < B.size()) {
            result.add(B.get(j));
            j++; 
        }
        
        return result; 
    }
}
