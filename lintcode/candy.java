public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     * 
     * O(n)
     */
    public int candy(int[] ratings) {
        int len = ratings.length; 
        int[] arr = new int[len]; 
        
        for (int i = 0; i < len; i++) {
            arr[i] = 1; 
            
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1; 
            }
        }
        
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1; 
            }
        }
        
        int result = 0; 
        
        for (int item : arr) {
            result += item; 
        }
        
        return result; 
    }
}
