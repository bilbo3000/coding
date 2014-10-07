public class Solution {
    private int cnt = 0; 
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num); 
        return helper(num, 0); 
    }
    
    private List<List<Integer>> helper(int[] num, int index) {
        int len = num.length; 
        List<List<Integer>> result;  
        
        if (index == len) {
            result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>()); 
            cnt = 1; 
            return result; 
        }
        
        result = helper(num, index + 1);
        
        if (index < len - 1 && num[index] == num[index + 1]) {
            int temp = 0; 
            int size = result.size(); 
            
            for (int i = size - cnt; i < size; i++) {
                List<Integer> item = new ArrayList<Integer>(result.get(i));
                item.add(0, num[index]); 
                result.add(item); 
                temp++; 
            }
            
            cnt = temp; 
        } else {
            int temp = 0; 
            int size = result.size(); 
            
            for (int i = 0; i < size; i++) {
                List<Integer> item = new ArrayList<Integer>(result.get(i));
                item.add(0, num[index]);
                result.add(item); 
                temp++; 
            }
            
            cnt = temp; 
        }
        
        return result; 
    }
}
