public class Solution {
    public int numDecodings(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] arr = new int[len];
        
        if (s.charAt(0) != '0') {
            arr[0] = 1; 
        }
        
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0; 
                }
                
                if (i > 1) {
                    arr[i] = arr[i - 2]; 
                } else {
                    arr[i] = 1; 
                }
                  
            } else {
                if ((s.charAt(i - 1) == '2' && s.charAt(i) > '6')  || s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0') {
                arr[i] = arr[i - 1]; 
            } else {
                if (i > 1) {
                    arr[i] = arr[i - 1] + arr[i - 2]; 
                } else {
                    arr[i] = arr[i - 1] + 1; 
                }
            }
            }
        }
        
        return arr[len - 1]; 
    }
}
