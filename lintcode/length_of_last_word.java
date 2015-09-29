public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        String[] arr = s.split("\\s+");
        int len = arr.length; 
        
        return arr[len - 1].length(); 
    }
}
