public class Solution2 {
    public String getPermutation(int n, int k) {        
        int fact = 1;  
        
        for (int i = n; i >= 1; i--) {
            fact *= i; 
        }
        
        k = (k - 1) % fact; 
        
        ArrayList<Character> arr = new ArrayList<Character>(); 
        
        for (int i = 1; i <= n; i++) {
        	arr.add((char)(i + '0')); 
        }
        
        String result = ""; 
        
        for (int i = n; i >= 1; i--) {
        	fact /= i; 
        	int temp = k / fact; 
        	result += arr.get(temp); 
        	arr.remove(temp); 
        	k = k % fact; 
        }
        
        return result; 
    }
}
