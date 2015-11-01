public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     * 
     * O(n)
     */
    public String addBinary(String a, String b) {
        int len1 = a.length(); 
        int len2 = b.length(); 
        
        if (len1 == 0) {
            return b; 
        }
        
        if (len2 == 0) {
            return a; 
        }
        
        StringBuilder res = new StringBuilder(); 
        int carry = 0; 
        int i = len1 - 1; 
        int j = len2 - 1; 
        
        while (i >= 0 && j >= 0) {
            int d1 = a.charAt(i) == '0' ? 0 : 1; 
            int d2 = b.charAt(j) == '0' ? 0 : 1; 
            int sum = d1 + d2 + carry; 
            int d = sum % 2; 
            carry = sum / 2; 
            res.insert(0, d);
            i--; 
            j--; 
        }
        
        while (i >= 0) {
            int d1 = a.charAt(i) == '0' ? 0 : 1; 
            int sum = d1 + carry; 
            int d = sum % 2; 
            carry = sum / 2; 
            res.insert(0, d);
            i--; 
        }
        
        while (j >= 0) {
            int d2 = b.charAt(j) == '0' ? 0 : 1; 
            int sum = d2 + carry; 
            int d = sum % 2; 
            carry = sum / 2; 
            res.insert(0, d);
            j--; 
        }
        
        if (carry != 0) {
            res.insert(0, 1);
        }
        
        return res.toString(); 
    }
}
