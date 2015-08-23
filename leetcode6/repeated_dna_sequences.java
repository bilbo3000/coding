import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Long, Integer> m = new HashMap<>(); 
        List<String> res = new ArrayList<>(); 
        int len = s.length(); 
        
        for (int i = 0; i <= len - 10; i++) {
            long key = stringToLong(s.substring(i, i + 10)); 
            
            if (!m.containsKey(key)) {
                m.put(key, 1);
            } else {
                m.put(key, m.get(key) + 1); 
            }
        }
        
        for (long key : m.keySet()) {
            if (m.get(key) >= 2) {
                res.add(longToString(key));
            }
        }
        
        return res; 
    }
    
    private long stringToLong(String s) {
        long res = 0; 
        
        for (int i = 0; i < 10; i++) {
            char c = s.charAt(i); 
            
            if (c == 'A') {
                res = res * 10 + 1; 
            } else if (c == 'C') {
                res = res * 10 + 2; 
            } else if (c == 'G') {
                res = res * 10 + 3; 
            } else {
                res = res * 10 + 4; 
            }
        }
        
        return res; 
    }
    
    private String longToString(long n) {
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < 10; i++) {
            long d = n % 10; 
            
            if (d == 1) {
                sb.insert(0, 'A');
            } else if (d == 2) {
                sb.insert(0, 'C');
            } else if (d == 3) {
                sb.insert(0, 'G');
            } else {
                sb.insert(0, 'T');
            }
            
            n = n / 10; 
        }
        
        return sb.toString();
    }
}
