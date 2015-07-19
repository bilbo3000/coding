/**
 * Find the shortest palindrome by adding prefix to a given array. 
 * The idea was for the given input string, we want to find the 
 * longest palindrome substring (could be whole string) starting 
 * from the left. The reason is that the longest palindrome starting
 * from the left would result minimum suffix that is not part of 
 * the palindrome, which further leads to minimum insertion of 
 * characters in the front. 
 */ 
public class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return s; 
        }
        
        int j = len - 1; 
        char[] arr = s.toCharArray(); 
        
        while (!isPalin(arr, 0, j)) {
            j--; 
        }
        
        if (j == len - 1) {
            return s; 
        } 
        
        String suffix = s.substring(j + 1);
        
        return new StringBuilder(suffix).reverse().toString() + s; 
    }
    
    private boolean isPalin(char[] arr, int i, int j) {
        if (i == j) {
            return true;
        }
        
        while (i <= j) {
            if (arr[i] != arr[j]) {
                return false; 
            }
            
            i++; 
            j--; 
        }
        
        return true;
    }
}
