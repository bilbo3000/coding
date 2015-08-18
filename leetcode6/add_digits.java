public class Solution {
    public int addDigits(int num) {
        while (num / 10 > 0) {
            int result = 0; 
            
            while (num > 0) {
                int digit = num % 10; 
                result += digit; 
                num = num / 10; 
            }
            
            num = result; 
        }
        
        return num;
    }
}
