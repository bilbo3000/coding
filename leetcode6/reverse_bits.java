/**
 * Reverse bits in an integer. 
 * Bit manipulation problem. The idea was two pointers moving towards each 
 * other and swap digits if two digits are different. To get a bit, we can 
 * shift it to the right 'index' number of times and & with 1. To swap bit, 
 * we can use xor. The idea was we only need to swap bits if two bits are 
 * different. Thus, we need to invert each bit and use can use xor to invert
 * bit (for a bit, xor with 1 invert, xor with 0 does nothing).
 */ 
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapbit(n, i, 32 - i - 1);
        }
        
        return n; 
    }
    
    private int swapbit(int n, int i, int j) {
        // Get two bits to be swaped 
        int a = (n >> i) & 1; 
        int b = (n >> j) & 1;
        
        if (a != b) {
            // Two bits are different, need to be swaped. 
            // Actually just need to revert the bit
            n = n ^ (1 << i); 
            n = n ^ (1 << j);
        }
        
        return n; 
    }
}
