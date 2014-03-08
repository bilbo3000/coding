public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        result.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j < result.size() - 1; j++) {
                int newVal = result.get(j) + result.get(j + 1); 
                result.set(j, newVal); 
            }
            
            result.add(0, 1); 
        }
        
        return result; 
    }
}
