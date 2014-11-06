public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> l = new ArrayList<Integer>(); 
        
        for (int i = 1; i <= n; i++) {
            l.add(i); 
        }
        
        return helper(k, l); 
    }
    
    private String helper(int k, List<Integer> l) {
        String result = ""; 
        
        if (k == 1) {
            for (int i = 0; i < l.size(); i++) {
                result += String.valueOf(l.get(i)); 
            }
            
            return result; 
        }
        
        int groupSize = factorial(l.size() - 1);
        int index = (k - 1) / groupSize; 
        int digit = l.get(index);
        l.remove(index);
        
        return String.valueOf(digit) + helper(k - index * groupSize, l); 
    }
    
    private int factorial(int x) {
        if (x <= 2) {
            return x; 
        }
        
        int result = 1; 
        
        for (int i = x; i > 1; i--) {
            result *= i; 
        }
        
        return result; 
    }
}
