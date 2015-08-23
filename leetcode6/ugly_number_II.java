/**
 * Find the nth ugly number. 
 * Borrow idea from mergesort. The observation is that each ugly number is an ugly number times either 2, 3, or 5. 
 * Thus, we can split them into three groups: 
 * 1x2, 2x2, 3x2, 4x2, 5x2, 6x2, 8x2, etc
 * 1x3, 2x3, 3x3, 4x3, 5x3, 6x3, 8x3, etc
 * 1x5, 2x5, 3x5, 4x5, 5x5, 6x5, 8x5, etc
 * Then we can user merge sort idea to pick the smallest ugly number to add to the result and advance that pointer. 
 * The tricky part is that three pointers will be on the result list (where ugly numbers are in ascending order).
 * Also, DO NOT add duplicate numbers. 
 */ 
public class Solution {
    public int nthUglyNumber(int x) {
        List<Integer> list = new ArrayList<>(); 
        list.add(1);
        int i1 = 0; 
        int i2 = 0; 
        int i3 = 0; 
        
        while (list.size() < x) {
            int n1 = list.get(i1) * 2; 
            int n2 = list.get(i2) * 3; 
            int n3 = list.get(i3) * 5; 
            int n = n1; 
            
            if (n2 < n) {
                n = n2; 
            }
            
            if (n3 < n) {
                n = n3; 
            }
            
            if (n != list.get(list.size() - 1)) {
            	list.add(n);
            }
            
            if (n == n1) {
                i1++; 
            } else if (n == n2) {
                i2++; 
            } else {
                i3++; 
            }
        }
        
        return list.get(list.size() - 1);
    }
}
