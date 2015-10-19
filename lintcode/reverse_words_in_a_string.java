public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder(); 
        int i = arr.length - 1; 
        
        while (i >= 0) {
            sb.append(arr[i]);
            sb.append(" ");
            i--; 
        }
        
        return sb.toString().trim(); 
    }
}

