public class BuyingTshirts {
    public int meet(int T, int[] Q, int[] P) {
        int len = Q.length; 
        int curr1 = 0; 
        int curr2 = 0; 
        int result = 0; 
        
        for (int i = 0; i < len; i++) {
            curr1 += Q[i]; 
            curr2 += P[i]; 
            
            if (curr1 >= T && curr2 >= T) {
                result++; 
            }
            
            if (curr1 >= T) {
                curr1 -= T; 
            }
            
            if (curr2 >= T) {
                curr2 -= T; 
            }
        }
        
        return result; 
    }
}
