/**
 * Find the minimum number of candy to give such that higher rating kids 
 * would have more candies than the neighbors. 
 * The idea was to go through the ratings in two passes. The first pass from 
 * left to right to make sure higher rating kids have one more candy than the 
 * kid in front, otherwise, set to minimum 1. The second pass from right to 
 * left to make sure higher rating kids have one more than the one after. 
 */ 
public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length; 
        int[] arr = new int[len];
        arr[0] = 1; 
        
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1; 
            } else {
                arr[i] = 1; 
            }
        }
        
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1; 
            }
        }
        
        int result = 0; 
        
        for (int i = 0; i < len; i++) {
            result += arr[i]; 
        }
        
        return result; 
    }
}
