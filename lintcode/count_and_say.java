public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        String res = "1"; 
        
        while (n > 1) {
            List<Integer> nums = new ArrayList<>(); 
            List<Integer> count = new ArrayList<>(); 
            
            int i = 0; 
            
            while (i < res.length()) {
                int d = (int) (res.charAt(i) - '0');
                
                if (i == 0 || res.charAt(i) != res.charAt(i - 1)) {
                    nums.add(d);
                    count.add(1);
                } else {
                    int size = count.size(); 
                    count.set(size - 1, count.get(size - 1) + 1);
                }
                
                i++; 
            }
            
            res = ""; 
            
            for (int j = 0; j < nums.size(); j++) {
                res += (char)(count.get(j) + '0');
                res += (char)(nums.get(j) + '0');
            }
            
            n--; 
        }
        
        return res; 
    }
}
