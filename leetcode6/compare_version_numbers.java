/**
 * Compare version numbers. 
 * The idea was to split the versions at dot (.) and add each number to queues. 
 * Then loop through the queue and compare each digit. Note that after exhaust one queue
 * the other queue may not be empty. For the non-empty queue, we need to keep poping the 
 * queue until we find the first non-zero value of till the queue become empty. If queue 
 * is empty, then two versions are the same where the one we just poped just has all tailing
 * zeros. If queue is not empty, then that version is larger. 
 */ 
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        
        Queue<Integer> q1 = new LinkedList<>(); 
        Queue<Integer> q2 = new LinkedList<>(); 
        
        for (String item1 : arr1) {
            q1.add(Integer.parseInt(item1));
        }
        
        for (String item2 : arr2) {
            q2.add(Integer.parseInt(item2));
        }
        
        while (q1.size() != 0 && q2.size() != 0) {
            int digit1 = q1.remove(); 
            int digit2 = q2.remove();
            
            if (digit1 > digit2) {
                return 1; 
            }
            
            if (digit1 < digit2) {
                return -1; 
            }
        }
        
        while (q1.size() != 0 && q1.peek() == 0) {
            q1.remove();
        }
        
        while (q2.size() != 0 && q2.peek() == 0) {
            q2.remove(); 
        }
        
        if (q1.size() != 0) {
            return 1; 
        }
        
        if (q2.size() != 0) {
            return -1; 
        }
        
        return 0; 
    }
}
