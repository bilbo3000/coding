public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>(); 
        List<List<Integer> > levels = new ArrayList<List<Integer> >(); 
        levels.add(new ArrayList<Integer>());
        levels.add(new ArrayList<Integer>()); 
        int lev0 = 0; 
        int lev1 = 1; 
        
        if (rowIndex < 0) {
            return result; 
        }
        
        levels.get(lev0).add(1);
        
        int i = 0; 
        while (i < rowIndex) {
            List<Integer> curr = levels.get(lev0); 
            List<Integer> next = levels.get(lev1);
            
            next.add(1);
            
            for (int j = 1; j < curr.size(); j++) {
                next.add(curr.get(j - 1) + curr.get(j));     
            }
            
            next.add(1);
            
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
            
            i++; 
        }
        
        return levels.get(lev0); 
    }
}
