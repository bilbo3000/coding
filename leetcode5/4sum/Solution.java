public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num); 
        int len = num.length; 
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        Set<List<Integer>> temp = new HashSet<List<Integer>>(); 
        
        for (int i = 0; i < len - 3; i++) {
            List<List<Integer>> t = threeSum(num, i + 1, target - num[i]);
            
            for (List<Integer> item : t) {
                List<Integer> quad = new ArrayList<Integer>(item); 
                quad.add(0, num[i]);
                
                if (!temp.contains(quad)) {
                    temp.add(quad); 
                }
            }
        }
        
        result.addAll(temp);
        
        return result; 
    }
    
    private List<List<Integer>> threeSum(int[] num, int index, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        Set<List<Integer>> temp = new HashSet<List<Integer>>(); 
        int len = num.length; 
        
        for (int i = index; i < len - 2; i++) {
            int l = i + 1; 
            int r = len - 1; 
            
            while (l < r) {
                int sum = num[i] + num[l] + num[r]; 
                
                if (sum == target) {
                    List<Integer> triplet = new ArrayList<Integer>(); 
                    triplet.add(num[i]);
                    triplet.add(num[l]);
                    triplet.add(num[r]); 
                    
                    if (!temp.contains(triplet)) {
                        temp.add(triplet); 
                    }
                    
                    l++; 
                    r--; 
                } else if (sum < target) {
                    l++; 
                } else {
                    r--; 
                }
            }
        }
        
        result.addAll(temp); 
        
        return result; 
    }
}
