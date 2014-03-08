public class Solution {
    int[] num; 
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        int len = num.length;
        this.num = num; 
        
        return helper(0, len); 
    }
    
    private ArrayList<ArrayList<Integer>> helper(int index, int len) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        
        if (index == len) {
            result.add(new ArrayList<Integer>()); 
            return result; 
        }
        
        ArrayList<ArrayList<Integer>> temp = helper(index + 1, len); 
        
        for (int i = 0; i < temp.size(); i++) {
            ArrayList<Integer> p; 
            
            for (int j = 0; j < temp.get(i).size(); j++) {
                p = new ArrayList<Integer>(temp.get(i)); 
                p.add(j, num[index]); 
                result.add(p); 
            }
            
            p = new ArrayList<Integer>(temp.get(i)); 
            p.add(num[index]); 
            result.add(p);
        }
        
        return result; 
    }
}
