/**
 * Find the minimum path from the top to the bottom of a triangle. 
 * The idea was to keep track of the minimum path sum to current 
 * level. After iterating through all levels, return the min element 
 * in the array. 
 */ 
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0; 
        }
        
        int h = triangle.size(); 
        int[] arr = new int[h]; 
        
        for (List<Integer> item : triangle) {
            for (int i = item.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    arr[i] = arr[i] + item.get(i);
                }
                else if (i == item.size() - 1) {
                    arr[i] = arr[i - 1] + item.get(i);
                } else {
                    arr[i] = Math.min(arr[i], arr[i - 1]) + item.get(i);
                }
            }
        }
        
        int min = arr[0]; 
        
        for (int i = 1; i < h; i++) {
            if (arr[i] < min) {
                min = arr[i]; 
            }
        }
        
        return min; 
    }
}
