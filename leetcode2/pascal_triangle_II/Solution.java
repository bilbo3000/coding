public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> p = new ArrayList<Integer>(Collections.nCopies(rowIndex + 1, 0)); 
        p.set(0, 1);
        
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = rowIndex; j > 0; j--) {
                p.set(j, p.get(j - 1) + p.get(j)); 
            }
        }
        
        return p; 
    }
}
