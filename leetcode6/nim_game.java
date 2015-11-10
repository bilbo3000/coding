/**
 * The idea is that when 
 * 1) n is [1..3], first player will win; 
 * 2) n is 4, first player will lost; 
 * 3) n is [5..7], first player will win; 
 * 4) n is 8, first player will lose, because no matter how the first player will choose, it will 
 * convert the problem to [5..7] for the second player and the second player will always win. 
 * 5) etc...
 */ 
public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
