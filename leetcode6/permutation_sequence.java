/**
 * Find the kth permutation. 
 * One approach would be calling next permutation k times, however, this approach would exceed time limit. 
 * Another solution is to solve it recursively. The idea was place all available digits in a list in increasing 
 * order, and each time determine what the first digit would be. The idea was for the n - 1 digits starting 
 * from the second digit, there are total (n - 1)! combinations. Thus, the first digit would be the m = k / (n - 1)! + 1th
 * element in the list, then we remove that element from the list and recursively process the remaining n - 1 digits
 * try to find the k - (m - 1) * (n - 1)! th permutation. 
 */ 
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>(); 
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        return helper(list, k); 
    }
    
    private String helper(List<Integer> list, int k) {
        int len = list.size(); 
        
        if (len == 0) {
            return ""; 
        }
        
        if (len == 1) {
            return String.valueOf(list.get(0));
        }
        
        String result = ""; 
        int f = fac(len - 1);
        int m = (k - 1) / f; 
        
        result = String.valueOf(list.get(m)); 
        list.remove(m);
        
        return result + helper(list, k - (m) * f); 
    }
    
    private int fac(int n) {
    	int result = n; 
    	n--; 
    	while (n > 0) {
    		result *= n; 
    		n--; 
    	}
    	
    	return result; 
    }
}
