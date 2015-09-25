public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     * 
     * Sort and then check duplicates. 
     */
    public boolean isUnique(String str) {
        // write your code here
        char[] arr = str.toCharArray(); 
        Arrays.sort(arr);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false; 
            }
        }
        
        return true; 
    }
}
