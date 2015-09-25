public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        Map<Character, Integer> m = new HashMap<>(); 
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50); 
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        
        int result = 0; 
        char[] arr = s.toCharArray(); 
        int len = arr.length; 
        
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && m.get(arr[i + 1]) > m.get(arr[i])) {
                result += m.get(arr[i + 1]); 
                result -= m.get(arr[i]);
                i++; 
            } else {
                result += m.get(arr[i]);
            }
        }
        
        return result; 
    }
}
