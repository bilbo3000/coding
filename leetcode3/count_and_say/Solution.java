public class Solution {
    public String countAndSay(int n) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>(); 
        levels.add(new ArrayList<Integer>());
        levels.add(new ArrayList<Integer>()); 
        int lev1 = 0; 
        int lev2 = 1; 
        levels.get(lev1).add(1); 
        int k = 1; 
        
        while (k < n) {
            ArrayList<Integer> curr = levels.get(lev1); 
            ArrayList<Integer> next = levels.get(lev2);
            int digit = curr.get(0); 
            int cnt = 1; 
            
            for (int i = 1; i < curr.size(); i++) {
                if (curr.get(i) == curr.get(i - 1)) {
                    cnt++; 
                }
                else {
                    next.add(cnt);
                    next.add(digit);
                    digit = curr.get(i); 
                    cnt = 1; 
                }
            }
            
            next.add(cnt); 
            next.add(digit); 
            
            curr.clear(); 
            lev1 = lev1 ^ lev2; 
            lev2 = lev1 ^ lev2; 
            lev1 = lev1 ^ lev2; 
            k++; 
        }
        
        String result = ""; 
        
        for (int i = 0; i < levels.get(lev1).size(); i++) {
            result += (char) (levels.get(lev1).get(i) + '0'); 
        }
        
        return result; 
    }
}
