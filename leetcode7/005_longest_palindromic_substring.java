/*
Find the longest palindrome in a string. 

The solution is to build a boolean 2D map where m[i][j] if s[i:j] is a palindrom. 
- m[i][j] automatically is palindrome; 
- m[i][i + 1] can be easily determined; 
- for other i, j combinations, m[i][j] depends on s[i] == s[j] and m[i + 1][j - 1] is a palindrome; 

The tricky part is that m[i][j] would depend on m[i + 1][j - 1], which is left-bottom cell. Thus 
need to compute the 2D map with bottom up left to right fashion. 

Time complexity: O(n^2)
Space complexity: O(n^2)

!!! Need to come up with better perf algorithm !!!
*/
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return s; 
        }
        
        int max = 1;
        boolean[][] m = new boolean[len][len];
        int index1 = 0; 
        int index2 = 0; 
        
        // Initialize diagnal to all 1 as a single character is palindrome
        for (int i = 0; i < len; i++) {
            m[i][i] = true; 
        }
        
        // Also initialize two characters case
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                m[i][i + 1] = true;
                max = 2; 
                index1 = i; 
                index2 = i + 1; 
            } 
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && m[i + 1][j - 1]) {
                    m[i][j] = true; 
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        index1 = i; 
                        index2 = j;
                    } 
                } 
            }
        }
        
        return s.substring(index1, index2 + 1); 
    }
}
