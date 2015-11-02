public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        Map<Character, Integer> m = new HashMap<>(); 
        char[] arr1 = A.toCharArray(); 
        char[] arr2 = B.toCharArray(); 
        
        for (int i = 0; i < arr1.length; i++) {
            if (!m.containsKey(arr1[i])) {
                m.put(arr1[i], 1);
            } else {
                m.put(arr1[i], m.get(arr1[i]) + 1);
            }
        }
        
        for (int j = 0; j < arr2.length; j++) {
            if (!m.containsKey(arr2[j])) {
                return false; 
            }
            
            if (m.get(arr2[j]) == 0) {
                return false; 
            }
            
            m.put(arr2[j], m.get(arr2[j]) - 1);
        }
        
        return true; 
    }
}
