/**
 * Divide two numbers. 
 * The idea was to update numerator and denominator each iteration and store 
 * divide result and modulo result. For each new modulo result, look through
 * the modulo list, if find the same element, meaning there must be a repeat 
 * since we've been there already, thus note the index and break the loop,
 * and the part from that index to the end of divide result list would be 
 * repeated. 
 * A couple of things: 
 * 1) convert to long before manipulation; 
 * 2) track the sign; 
 */ 
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
    	boolean isNeg = false; 
    	long n = (long) numerator; 
    	long d = (long) denominator; 
    	
    	if (n < 0 && d < 0) {
    		n = -n; 
    		d = -d; 
    	}
    	else if (n < 0) {
    		isNeg = true; 
    		n = -n; 
    	} else if (d < 0){
    		isNeg = true; 
    		d = -d; 
    	}
    	
        List<Long> div = new ArrayList<>(); 
        List<Long> mod = new ArrayList<>(); 
        int index = 0; 
        
        do {
             long x = n / d; 
             long y = n % d; 
             div.add(x);
             
             for (int i = 0; i < mod.size(); i++) {
                 if(mod.get(i) == y) {
                     // Found a repeat
                     index = i + 1; 
                     break; 
                 }
             }
             
             if (index != 0) {
            	 break; 
             }
             
             mod.add(y);
             n = y * 10; 
        } while (n != 0);
        
        if (div.size() == 1) {
        	if (isNeg) {
        		return String.valueOf(-div.get(0));
        	}
            return String.valueOf(div.get(0)); 
        }
        
        StringBuilder sb = new StringBuilder();
        if(isNeg) {
        	sb.append("-");
        }
        sb.append(div.get(0));
        sb.append("."); 
        
        if (index == 0) {
            // No repeat 
            for (int i = 1; i < div.size(); i++) {
                sb.append(div.get(i));
            }
            
            return sb.toString(); 
        }
        
        // There is repeat 
        for (int i = 1; i < index; i++) {
            sb.append(div.get(i));
        }
        
        sb.append("(");
        
        for (int i = index; i < div.size(); i++) {
            sb.append(div.get(i));
        }
        
        sb.append(")");
        
        return sb.toString(); 
    }
}
