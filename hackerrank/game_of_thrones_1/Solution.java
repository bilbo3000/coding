import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans;
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        Map<Character, Integer> m = new HashMap<Character, Integer>(); 
        int len = inputString.length(); 
        
        for (int i = 0; i < len; i++) {
            char c = inputString.charAt(i); 
            
            if (!m.containsKey(c)) {
                m.put(c, 1); 
            } else {
                m.put(c, m.get(c) + 1); 
            }
        }
        
        int cnt = 0; 
        Set<Character> keySet = m.keySet(); 
        
        for (Character key : keySet) {
            if (m.get(key) % 2 != 0) {
                cnt++; 
            }
        }
        
        if (cnt > 1) {
            ans = "NO"; 
        } else {
            ans = "YES"; 
        }
        
        System.out.println(ans);
        myScan.close();
    }
}
