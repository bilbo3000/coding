public class GreaterGameDiv2 {
    public int calc(int[] snuke, int[] sothe) {
        int len = snuke.length; 
        int result = 0; 
        
        for (int i = 0; i < len; i++) {
            if (snuke[i] > sothe[i]) {
                result++; 
            }
        }
        
        return result;
    }
}
