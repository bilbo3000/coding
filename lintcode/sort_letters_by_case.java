public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     * Similar to sort color. The index points to the last lower case letter.
     * Initialize the index to -1. 
     * O(n). 
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int index = -1; 
        int len = chars.length; 
        
        for (int i = 0; i < len; i++) {
            char c = chars[i]; 
            
            if (c >= 'a' && c <= 'z') {
                // lower case 
                index++; 
                chars[i] = chars[index]; 
                chars[index] = c; 
            }
        }
    }
}

