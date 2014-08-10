public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num); 
        Set<List<Integer>> temp = new HashSet<List<Integer>>(); 
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        int len = num.length; 
        
        for (int i = 0; i < len - 3; i++) {
            Set<List<Integer>> set = threeSum(num, i + 1, target - num[i]); 
            for (List<Integer> item : set) {
                item.add(0, num[i]);
                temp.add(item); 
            }
        }
        
        result.addAll(temp); 
        
        return result; 
    }
    
    private Set<List<Integer>> threeSum(int[] num, int index, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>(); 
        int len = num.length; 
        for (int i = index; i < len; i++) {
            int l = i + 1; 
            int r = len - 1; 
            
            while (l < r) {
                int sum = num[i] + num[l] + num[r]; 
                if (sum == target) {
                    result.add(new ArrayList<Integer>(Arrays.asList(num[i], num[l], num[r])));
                    l++; 
                    r--; 
                } else if (sum < target) {
                    l++; 
                } else {
                    r--; 
                }
            }
        }
        
        return result; 
    }
}
