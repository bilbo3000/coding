public class AliceGameEasy {
    private long min = Long.MAX_VALUE;
    private boolean found = false;

    public  long findMinimumValue(long x, long y) {
        long totalPoints = 0; 
        long turn = 0; 
        
        while (true) {
            if (x + y <= totalPoints) {
                break; 
            }
            
            turn++; 
            totalPoints += turn;
        }
        
        if (totalPoints > x + y) {
            return - 1; 
        }
        
        long aliceWin = 0; 
        
        for (long i = turn; i > 0; i--) {
            if (x > i) {
                aliceWin++; 
                x -= i; 
            }
        }
        
        return aliceWin; 
    }
}
