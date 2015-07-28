/**
 * Calculate the ith level of pascal triangle. 
 * The ideas was for each new level, walk through the old level backwards
 * and replace each element with the sum of that element and the previous 
 * element. After replacing each element, append a 1 at the end to complete 
 * that level. 
 */ 
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(); 
        
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = result.size() - 1; j > 0; j--) {
                int n = result.get(j) + result.get(j - 1); 
                result.set(j, n); 
            }
            result.add(1);
        }
        
        return result; 
    }
}
