public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     * 
     * O(n) time, O(1) space -- because just need to create an array with 
     * constant size (26 + 26 + 1), thus it is constant space. 
     */
    public boolean anagram(String s, String t) {
        int len1 = s.length(); 
        int len2 = t.length(); 
        
        if (len1 != len2) {
            return false; 
        }
        
        int[] arr1 = new int[53]; 
        int[] arr2 = new int[53]; 
        
        for (int i = 0; i < len1; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if (c1 == ' ') {
                arr1[52]++;
            } else if (Character.isLowerCase(c1)) {
                // Lower cases
                int index1 = (int)(c1 - 'a'); 
                arr1[index1]++; 
            } else {
                int index1 = (int)(c1 - 'A') + 26;
                arr1[index1]++; 
            }
            
            if (c2 == ' ') {
                arr2[52]++; 
            } else if (Character.isLowerCase(c2)) {
                int index2 = (int)(c2 - 'a');
                arr2[index2]++; 
            } else {
                int index2 = (int)(c2 - 'A') + 26; 
                arr2[index2]++; 
            }
        }
        
        for (int i = 0; i <= 52; i++) {
            if (arr1[i] != arr2[i]) {
                return false; 
            }
        }
        
        return true; 
    }
};
