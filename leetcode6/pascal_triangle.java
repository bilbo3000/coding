/**
 * Calculate the pascal triangle with the given number of levels. 
 * The idea was that each element of the middle section is the sum
 * of two elements of previous level right above it. After finding 
 * all the elements in the middle section. We just need to append 1s
 * in the front and at the end. 
 */ 
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        if (numRows == 0) {
            return result; 
        }
        
        List<Integer> temp = new ArrayList<>(); 
        temp.add(1);
        result.add(temp);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> item = new ArrayList<>(); 
            List<Integer> prev = result.get(i - 1); 
            
            for (int j = 1; j < prev.size(); j++) {
                item.add(prev.get(j - 1) + prev.get(j)); 
            }
            item.add(0, 1);
            item.add(1); 
            result.add(item);
        }
        
        return result; 
    }
}
