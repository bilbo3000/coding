public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     * 
     * First reverse the whole string. Then reverse the first part and second 
     * part separately. 
     * 
     * O(n) time, in place, O(1) extra memory. 
     */
    public void rotateString(char[] str, int offset) {
        if (str.length == 0) return; 
        
        offset = offset % str.length; 
        
       // first reverse the whole string
       int i = 0; 
       int j = str.length - 1; 
       
       while (i < j) {
           swap(str, i, j);
           i++; 
           j--; 
       }
       
       // reverse the first part 
       i = 0; 
       j = offset - 1; 
       
       while (i < j) {
           swap(str, i, j);
           i++; 
           j--; 
       }
       
       // reverse the second part 
       i = offset; 
       j = str.length - 1; 
       
       while (i < j) {
           swap(str, i, j);
           i++; 
           j--; 
       }
    }
    
    private void swap(char[] str, int i, int j) {
        char temp = str[i]; 
        str[i] = str[j]; 
        str[j] = temp; 
    }
}
