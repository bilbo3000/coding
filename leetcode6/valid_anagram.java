/**
 * Check if given two strings are anagrams. 
 * The idea was to first convert two strings to char array. Then 
 * sort the array. They are anagrams if two arrays contain the 
 * same characters.
 */ 
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false; 
        }
        
        if (s.equals(t)) {
            return true; 
        }
        
        if (s.length() != t.length()) {
            return false; 
        }
        
        char[] arr1 = s.toCharArray(); 
        char[] arr2 = t.toCharArray(); 
        
        Arrays.sort(arr1); 
        Arrays.sort(arr2);
        
        int i = 0; 
        
        while (i < arr1.length) {
            if (arr1[i] != arr2[i]) {
                return false; 
            }
            
            i++; 
        }
        
        return true; 
    }
}
