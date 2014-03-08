public class Solution {
    public String countAndSay(int n) {
        ArrayList<Integer> cnt = new ArrayList<Integer>(); 
        ArrayList<Integer> digit = new ArrayList<Integer>(); 
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        
        result.add(1); 
        
        while (n > 1) { 
        	cnt.clear();
        	digit.clear();
        	
        	// Count 
        	digit.add(result.get(0));
        	cnt.add(1); 
        	int i = 1; 
        	
        	while (i < result.size()) {
        		if (result.get(i) == result.get(i - 1)) {
        			int temp = cnt.get(cnt.size() - 1) + 1; 
        			cnt.set(cnt.size() - 1, temp); 
        		}
        		else {
        			cnt.add(1); 
        			digit.add(result.get(i)); 
        		}
        		
        		i++; 
        	}
        	
        	// Build next result
        	result.clear(); 
        	
        	for (int j = 0; j < cnt.size(); j++) {
        		result.add(cnt.get(j)); 
        		result.add(digit.get(j)); 
        	}
        	
        	n--; 
        }
        
        String say = ""; 
        
        for (Integer item : result) {
        	say += item; 
        }
    	return say; 
    }
}
