public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        Arrays.sort(num); 
        int len = num.length; 
        int i = 0; 
        
        while (i < len) { 
            int j = i + 1; 
            int k = len - 1; 
            
            while (j < k) {
                int sum = num[i] + num[j] + num[k]; 
                
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(); 
                    temp.add(num[i]); 
                    temp.add(num[j]); 
                    temp.add(num[k]); 
                    result.add(temp); 
                    
                    do {
                        j++; 
                    } while (j < k && num[j] == num[j - 1]); 
                    
                    do {
                        k--; 
                    } while (j < k && num[k] == num[k + 1]); 
                }
                else if (sum > 0){
                    do {
                        k--; 
                    } while (j < k && num[k] == num[k + 1]); 
                }
                else {
                    do {
                        j++; 
                    } while (j < k && num[j] == num[j - 1]); 
                }
            }
            
            do {
                i++; 
            } while (i < len && num[i] == num[i - 1]); 
        }
        
        return result; 
    }
}
