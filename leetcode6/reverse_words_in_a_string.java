/**
 * Reverse words in a string. 
 */ 
public class Solution {
    public String reverseWords(String s) {
        s = s.trim(); 
        String[] arr = s.split("\\s+");
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list); 
        StringBuilder sb = new StringBuilder(); 
        
        for (String item : list) {
            sb.append(" ").append(item);
        }
        
        return sb.toString().trim();
    }
}
