/**
 * Find the nth count and say sequence. For instance, 1st is 1, 2nd is 11, 3rd is 21. 
 * The idea was to count the number of elements in each cluster. 
 */ 
public class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return ""; 
        }
        
        List<Integer> list = new ArrayList<>(); 
        list.add(1);
        
        while (n > 1) {
            List<Integer> temp = new ArrayList<>(); 
            int len = list.size(); 
            int i = 0; 
            int count = 0; 
            
            while (i < len) {
                if (i > 0 && list.get(i) != list.get(i - 1)) {
                    temp.add(count); 
                    temp.add(list.get(i - 1));
                    count = 1;
                } else {
                    count++; 
                }
                
                i++; 
            }
            
            temp.add(count);
            temp.add(list.get(i - 1));
            list = temp; 
            
            n--; 
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        for (Integer val : list) {
            sb.append(String.valueOf(val));
        }
        
        return sb.toString(); 
    }
}
