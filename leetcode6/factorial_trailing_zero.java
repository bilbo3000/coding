/**
 * Find the number of trailing zeros in n!. 
 * We know that each 2,5 pairs contribute to one additional tailing zero. Also, 2 factors must 
 * more than 5 factors. Because even number must more than multiple of 5. So we just need to 
 * count number of factors 5. Note that numbers like 5, 15, 20, contribute one 5. Numbers like 
 * 25, 50, 75, etc contribute two 5 each, etc. The algorithm below will collect a layer of 5 each 
 * iterator and add to the result. 
 */ 
public class Solution {
    public int trailingZeroes(int n) {
        int res = 0; 
        
        while (n > 0) {
            n = n / 5; 
            res += n; 
        }
        
        return res; 
    }
}
