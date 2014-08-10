public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num); 
        Set<List<Integer>> temp = new HashSet<List<Integer>>(); 
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        int len = num.length; 
        
        if (len == 0) {
            return result; 
        }
        
        for (int i = 0; i < len - 2; i++) {
            helper(num, i, temp); 
        }
        
        result.addAll(temp);
        
        return result; 
    }
    
    private void helper(int[] num, int index, Set<List<Integer>> result) {
        int len = num.length; 
        
        int l = index + 1; 
        int r = len - 1; 
        
        while (l < r) {
            int sum = num[l] + num[r]; 
            if (sum == -num[index]) {
                result.add(new ArrayList<Integer>(Arrays.asList(num[index], num[l], num[r]))); 
                l++; 
                r--; 
            } else if (sum < -num[index]) {
                l++; 
            } else {
                r--; 
            }
        }
    }
}
