/**
 * Find a sequence of letters with length that appear more than once. 
 * The core idea was to encode each letter to save space. Since we have 4 letters, two bits 
 * encoding is enough. Since length is ten, thus 20 bits is enough, fits in one integer. 
 * Since 20 bits gives 2^20 possibilities, thus we can build a boolean[2014 * 2014] to track 
 * the result. Note that each time when shift to left, don't forget to reset the overflow two 
 * bits (x & ((1 << 20) - 1)). 
 */ 
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>(); 
        List<Integer> keys = new ArrayList<>();
        int len = s.length(); 
        
        if (len < 10) {
            return res; 
        }
        
        int[] arr = new int[1024 * 1024]; 
        
        int key = 0; 
        
        // Find first key
        for (int i = 0; i < 10; i++) {
            char c = s.charAt(i); 
            key = key << 2; 
            key = key & ((1 << 20) - 1);
            
            if (c == 'A') {
                // No op
            } else if (c == 'C') {
                key = key | 1; 
            } else if (c == 'G') {
                key = key | 2; 
            } else if (c == 'T'){
                key = key | 3;
            }
        }
        
        arr[key] = 1; 
        
        for (int i = 10; i < len; i++) {
            char c = s.charAt(i); 
            key = key << 2; 
            key = key & ((1 << 20) - 1);
            
            if (c == 'A') {
                key = key | 0;
            } else if (c == 'C') {
                key = key | 1; 
            } else if (c == 'G') {
                key = key | 2; 
            } else if (c == 'T'){
                key = key | 3;
            }
                        
        	arr[key]++; 
        	
            if (arr[key] == 2) {
            	keys.add(key);
            }
        }
                
        for (int item : keys) {
            StringBuilder sb = new StringBuilder(); 
            
            for (int i = 0; i < 10; i++) {
                int d = item % 4; 
                
                if (d == 0) {
                    sb.insert(0, 'A');
                } else if (d == 1) {
                    sb.insert(0, 'C');
                } else if (d == 2) {
                    sb.insert(0, 'G');
                } else if (d == 3){
                    sb.insert(0, 'T');
                }
                
                item = item / 4; 
            }
            
            res.add(sb.toString());
        }
        
        return res; 
    }
}
